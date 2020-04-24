package com.brume.dynamicdatamapper.usecases.repositories;

import java.util.List;

import com.brume.dynamicdatamapper.domain.models.Attribute;
import com.brume.dynamicdatamapper.domain.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttributeRepository extends JpaRepository<Attribute, Long> {
    List<Attribute> findByProviderAndKeyAndValueContainingIgnoreCase(Provider provider, String key,
                                                                     String query);

    List<Attribute> findByProviderAndKeyAndNumericValueGreaterThan(Provider provider, String key, int query);

    List<Attribute> findByProviderAndKeyAndNumericValueLessThan(Provider provider, String key, int query);

    List<Attribute> findByProviderAndKeyAndNumericValueEquals(Provider provider, String key, int query);

}