package com.brume.dynamicdatamapper.domain.models;

import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

@Data @Entity @NoArgsConstructor
public class Entry {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @Nullable
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @OneToMany(mappedBy = "entry", cascade = CascadeType.PERSIST)
    private List<Attribute> attributes;

    public static Map<String, Object> toMap(Entry entry) {
        List<Attribute> attributesList = entry.getAttributes();
        Map<String, Object> result = new HashMap<>();

        for (Attribute attribute : attributesList)
            switch (attribute.getType ()) {
                case "integer":
                    result.put ( attribute.getKey (), attribute.getNumericValue () );
                    break;
                case "string":
                    result.put ( attribute.getKey (), attribute.getValue () );
                    break;
            }

        return result;
    }
}