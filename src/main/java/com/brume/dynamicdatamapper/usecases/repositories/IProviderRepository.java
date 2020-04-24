package com.brume.dynamicdatamapper.usecases.repositories;


import com.brume.dynamicdatamapper.domian.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProviderRepository extends JpaRepository<Provider, Long> {

}