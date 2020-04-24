package com.brume.dynamicdatamapper.usecases.service;

import com.brume.dynamicdatamapper.domian.entity.DataSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Brume
 **/
@Repository
public interface DataSpecInterface extends JpaRepository<DataSpecification, Long> {

}
