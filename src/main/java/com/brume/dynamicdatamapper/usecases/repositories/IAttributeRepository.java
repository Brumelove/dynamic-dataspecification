package com.brume.dynamicdatamapper.usecases.repositories;

import java.util.List;

import com.brume.dynamicdatamapper.domian.models.Attribute;
import com.brume.dynamicdatamapper.domian.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttributeRepository extends JpaRepository<Attribute, Long> {
    public List<Attribute> findByProviderAndKeyAndValueContainingIgnoreCase(Provider provider, String key,
                                                                            String query);

    public List<Attribute> findByProviderAndKeyAndNumericValueGreaterThan(Provider provider, String key, int query);

    public List<Attribute> findByProviderAndKeyAndNumericValueLessThan(Provider provider, String key, int query);

    public List<Attribute> findByProviderAndKeyAndNumericValueEquals(Provider provider, String key, int query);

}