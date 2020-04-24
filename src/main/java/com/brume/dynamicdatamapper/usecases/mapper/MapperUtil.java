//package com.brume.dynamicdatamapper.usecases.mapper;
//
//import com.brume.dynamicdatamapper.domian.entity.DataSpecification;
//import com.brume.dynamicdatamapper.usecases.payload.DataSpecificationRequest;
//import lombok.val;
//import org.springframework.stereotype.Component;
//
//import java.util.function.Function;
//
///**
// * @author Brume
// **/
//@Component
//public class MapperUtil {
//    public Function<DataSpecification, DataSpecificationRequest> mapDataSpecification = dataSpecification -> {
//        val dataSpecificationRequest = new DataSpecificationRequest ();
//        dataSpecificationRequest.setFields ( dataSpecification.getFields () );
//        dataSpecificationRequest.setProviderId ( dataSpecification.getProviderId () );
//        return dataSpecificationRequest;
//    };
//}
