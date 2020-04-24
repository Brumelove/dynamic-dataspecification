//package com.brume.dynamicdatamapper.infrastructure.controller;
//
//import com.brume.dynamicdatamapper.domian.entity.DataSpecification;
//import com.brume.dynamicdatamapper.usecases.exception.ErrorDTO;
//import com.brume.dynamicdatamapper.usecases.payload.DataSpecificationResponse;
//import com.brume.dynamicdatamapper.usecases.service.DataSpecificationService;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import lombok.extern.slf4j.Slf4j;
//import lombok.val;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//
///**
// * @author Brume
// **/
//@Slf4j
//@RestController
//public class DataSpecificationController {
//    public final DataSpecificationService dataSpecificationService;
//
//    @Autowired
//
//    public DataSpecificationController(DataSpecificationService dataSpecificationService) {
//        this.dataSpecificationService = dataSpecificationService;
//    }
//
//    @PostMapping("/v1/save")
//    @ApiOperation(value = "", notes = "Save Data spec")
//    @ApiResponses(value = {
//            @ApiResponse(code = 204, message = "No content", response = ErrorDTO.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDTO.class),
//            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDTO.class),
//            @ApiResponse(code = 500, message = "Internal Server EmailError", response = ErrorDTO.class)
//    })
//    @ResponseStatus(HttpStatus.CREATED)
//public DataSpecification savethis(@RequestBody @Valid DataSpecification dataSpecification) {
//        log.info ( "savingggggggggg" );
//        return dataSpecificationService.updateDataSpec ( dataSpecification );
//    }
//}
