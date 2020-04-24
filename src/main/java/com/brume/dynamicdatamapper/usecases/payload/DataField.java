package com.brume.dynamicdatamapper.usecases.payload;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;


/**
 * @author Brume
 **/
@Data @Builder
public class DataField {
    private String name;
    private String age;
    private Timestamp timestamp;
}
