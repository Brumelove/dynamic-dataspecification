package com.brume.dynamicdatamapper.usecases.repositories;

import com.brume.dynamicdatamapper.domian.models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntryRepository extends JpaRepository<Entry, Long> {
    
}