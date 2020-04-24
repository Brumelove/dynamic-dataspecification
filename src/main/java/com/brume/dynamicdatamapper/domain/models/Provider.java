package com.brume.dynamicdatamapper.domain.models;

import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data @Entity @NoArgsConstructor
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long provider_id;

    @OneToMany(mappedBy = "provider")
    private List<Entry> entries;

    private String fields;
}