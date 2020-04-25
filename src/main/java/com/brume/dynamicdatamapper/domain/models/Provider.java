package com.brume.dynamicdatamapper.domain.models;

import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data @Entity @NoArgsConstructor
public class Provider {

    @Id
    private Long id;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.PERSIST)
    private List<Entry> entries;

    private String fields;
}