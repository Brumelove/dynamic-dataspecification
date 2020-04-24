package com.brume.dynamicdatamapper.usecases.serviceProviders;

import com.brume.dynamicdatamapper.domain.models.Attribute;
import com.brume.dynamicdatamapper.domain.models.Entry;
import com.brume.dynamicdatamapper.domain.models.Provider;
import com.brume.dynamicdatamapper.usecases.repositories.IAttributeRepository;
import com.brume.dynamicdatamapper.usecases.repositories.IEntryRepository;
import com.brume.dynamicdatamapper.usecases.repositories.IProviderRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppServiceProvider {

    private final IAttributeRepository attributeRepository;

    private final IProviderRepository providerRepository;

    private final IEntryRepository entryRepository;


    @Autowired
    public AppServiceProvider(IAttributeRepository attributeRepository, IProviderRepository providerRepository, IEntryRepository entryRepository) {
        this.attributeRepository = attributeRepository;
        this.providerRepository = providerRepository;
        this.entryRepository = entryRepository;
    }

    public ExecutionMethodResponse createDataSpecification(Long providerId, List<String> fields) {
        if (fields.size () == 0) {
            return new ExecutionMethodResponse ( false, "fields definition can't be empty" );
        }

        val provider = new Provider ();
        provider.setId( providerId );
        provider.setFields ( String.join ( ",", fields ) );

        providerRepository.save ( provider );

        return new ExecutionMethodResponse ( true, "successfully created provider" );

    }

    public ExecutionMethodResponse loadData(Long providerId, List<Map<String, Object>> data) {
        // so we'd first check if the provider exists.
        Optional<Provider> provider = providerRepository.findById ( providerId );
        if (provider.isPresent ()) {
            // next we validate the field specification.

            Set<String> fields = new HashSet<> ( Arrays.asList ( provider.get ().getFields ().split ( "," ) ) );
            List<Entry> entriesToSave = new ArrayList<> ();
            for (int i = 0; i < data.size (); i++) {
                Entry entry = new Entry ();
                entry.setProvider ( provider.get () );

                Map<String, Object> singleEntry = data.get ( i );
                Set<String> listOfKeys = singleEntry.keySet ();
                listOfKeys.removeAll ( fields );

                if (listOfKeys.size () > 0) {
                    return new ExecutionMethodResponse ( false, "Fields " + String.join ( ", ", listOfKeys )
                                                                + " weren't specified when creating the provider" );
                }

                List<Attribute> attributesList = new ArrayList<> ();

                for (Map.Entry<String, Object> attributeMap : singleEntry.entrySet ()) {
                    attributesList.add ( Attribute.fromMapEntry ( entry, attributeMap ) );
                }

                entry.setAttributes ( attributesList );

                entriesToSave.add ( entry );
            }

            Provider gottenProvider = provider.get ();
            gottenProvider.setEntries ( entriesToSave );

            providerRepository.save ( gottenProvider );

            return new ExecutionMethodResponse ( true, "" );

        }
        return new ExecutionMethodResponse ( false, "Could not find provider" );
    }

    public List<Map<String, Object>> getDataForProvider(Long providerId, Map<String, String> filters) {
        Optional<Provider> provider = providerRepository.findById ( providerId );
        if (!provider.isPresent ()) {
            return null;
        }

        Provider gottenProvider = provider.get ();

        List<Map<String, Object>> results = new ArrayList<> ();
        Map<Long, Entry> entriesMap = new HashMap<> ();

        if (filters.size () > 0) {
            for (Map.Entry<String, String> filterEntry : filters.entrySet ()) {
                String attributeKey = filterEntry.getKey ();
                String filterValue = filterEntry.getValue ();

                List<String> filterSplit = Arrays.asList ( filterValue.split ( ":" ) );
                if (filterSplit.size () != 2) {
                    continue;
                }

                List<Attribute> searchResults = new ArrayList<> ();
                if (filterSplit.get ( 0 ).equals ( "eqc" )) {
                    // this means we're comparing strings
                    searchResults = attributeRepository.findByProviderAndKeyAndValueContainingIgnoreCase ( gottenProvider,
                            attributeKey, filterSplit.get ( 1 ) );
                }

                switch (filterSplit.get ( 0 )) {
                    case "eq":
                        searchResults = attributeRepository.findByProviderAndKeyAndNumericValueEquals ( gottenProvider,
                                attributeKey, Integer.parseInt ( filterSplit.get ( 1 ) ) );
                        break;
                    case "gt":
                        searchResults = attributeRepository.findByProviderAndKeyAndNumericValueGreaterThan (
                                gottenProvider, attributeKey, Integer.parseInt ( filterSplit.get ( 1 ) ) );
                        break;
                    case "lt":
                        searchResults = attributeRepository.findByProviderAndKeyAndNumericValueLessThan ( gottenProvider,
                                attributeKey, Integer.parseInt ( filterSplit.get ( 1 ) ) );
                        break;
                }

                for (Attribute attribute : searchResults) {
                    Entry entry = attribute.getEntry ();
                    entriesMap.put ( entry.getId (), entry );
                }
            }

        }

        for (Map.Entry<Long, Entry> entryMapSet : entriesMap.entrySet ()) {
            results.add ( Entry.toMap ( entryMapSet.getValue () ) );
        }

        return results;
    }

}