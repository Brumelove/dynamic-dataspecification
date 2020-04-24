package com.brume.dynamicdatamapper.usecases.payload;

import com.brume.dynamicdatamapper.domian.entity.Fields;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author Brume
 **/
@Data
public class DataSpecificationRequest {
    private Integer providerId;
    private List<Fields> fields ;
}
