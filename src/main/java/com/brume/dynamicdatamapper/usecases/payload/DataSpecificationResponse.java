package com.brume.dynamicdatamapper.usecases.payload;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Brume
 **/
@Data @Builder
public class DataSpecificationResponse {
    private String name;
    private String age;
    private Timestamp timestamp;
}
