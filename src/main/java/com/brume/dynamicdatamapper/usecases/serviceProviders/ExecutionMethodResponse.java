package com.brume.dynamicdatamapper.usecases.serviceProviders;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class ExecutionMethodResponse {
    private boolean success;
    private String reason;


}