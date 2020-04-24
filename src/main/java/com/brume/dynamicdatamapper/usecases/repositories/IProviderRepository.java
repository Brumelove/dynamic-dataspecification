package com.brume.dynamicdatamapper.usecases.repositories;


import com.brume.dynamicdatamapper.domain.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProviderRepository extends JpaRepository<Provider, Long> {

}