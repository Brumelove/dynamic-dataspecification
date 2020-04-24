//package com.brume.dynamicdatamapper.usecases.service;
//
//import com.brume.dynamicdatamapper.domian.entity.DataSpecification;
//import com.brume.dynamicdatamapper.usecases.mapper.MapperUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
///**
// * @author Brume
// **/
//@Service
//public class DataSpecificationService implements Specification<DataSpecification> {
//    private final DataSpecInterface dataSpecInterface;
//    private final MapperUtil mapperUtil;
//
//    @Autowired
//    public DataSpecificationService(DataSpecInterface dataSpecInterface, MapperUtil mapperUtil) {
//        this.dataSpecInterface = dataSpecInterface;
//        this.mapperUtil = mapperUtil;
//    }
//
//
//    @Override
//    public Predicate toPredicate(Root<DataSpecification> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//
//        return null;
//    }
//    public DataSpecification updateDataSpec( DataSpecification dataSpecification) {
//        dataSpecInterface.save ( dataSpecification );
//
//        return dataSpecification;
//    }
//}
