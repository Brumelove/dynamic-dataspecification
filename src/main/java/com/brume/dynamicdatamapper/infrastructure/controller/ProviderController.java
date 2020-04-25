package com.brume.dynamicdatamapper.infrastructure.controller;

import java.util.List;
import java.util.Map;

import com.brume.dynamicdatamapper.usecases.serviceProviders.AppServiceProvider;
import com.brume.dynamicdatamapper.usecases.serviceProviders.ExecutionMethodResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ProviderController {
    private final AppServiceProvider appServiceProvider;

    @Autowired
    public ProviderController(AppServiceProvider appServiceProvider) {
        this.appServiceProvider = appServiceProvider;
    }


    @PostMapping(value = "providerspecification")
    public ResponseEntity createProviderSpecification(@RequestBody Map<String, Object> request) {
        // TODO: process POST request

        Long providerId = Long.valueOf ( String.valueOf ( request.get ( "providerId" ) ) );
        List<String> fields = (List) request.get ( "fields" );

        ExecutionMethodResponse output = appServiceProvider.createDataSpecification ( providerId, fields );

        if (!output.isSuccess ()) {
            return ResponseEntity.badRequest ().body ( output );
        }

        return ResponseEntity.ok ().body ( output );
    }

    @PostMapping(value = "/providerdata")
    public ResponseEntity loadProviderData(@RequestBody Map<String, Object> request) {
        Long providerId = Long.valueOf ( String.valueOf ( request.get ( "providerId" ) ) );
        List<Map<String, Object>> data = (List<Map<String, Object>>) request.get ( "data" );


        ExecutionMethodResponse output = appServiceProvider.loadData ( providerId, data );

        if (!output.isSuccess ()) {
            return ResponseEntity.badRequest ().body ( output );
        }

        return ResponseEntity.ok ().body ( output );
    }

    @GetMapping(value = "/filter/{providerId}")
    public ResponseEntity getMethodName(@PathVariable("providerId") Long providerId,
                                        @RequestParam Map<String, String> queires) {

        List<Map<String, Object>> response = appServiceProvider.getDataForProvider ( providerId, queires );

        return ResponseEntity.ok ().body ( response );
    }

}