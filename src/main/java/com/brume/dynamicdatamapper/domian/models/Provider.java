package com.brume.dynamicdatamapper.domian.models;

import java.util.List;

import javax.persistence.OneToMany;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Provider {

    @Id
    private Long id;

    @OneToMany(mappedBy = "provider")
    private List<Entry> entries;

    private String fields;
}