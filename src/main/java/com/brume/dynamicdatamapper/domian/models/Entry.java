package com.brume.dynamicdatamapper.domian.models;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

@Data
public class Entry {

    @GeneratedValue
    private Long id;

    private Provider provider;

    @OneToMany(mappedBy = "entry")
    private List<Attribute> attributes;

    public static Map<String, Object> toMap(Entry entry) {
        List<Attribute> attributesList = entry.getAttributes();
        Map<String, Object> result = new HashMap<>();

        for (Attribute attribute : attributesList) {
            switch (attribute.getType()) {
                case "integer":
                    result.put(attribute.getKey(), attribute.getNumericValue());
                    break;
                case "string":
                    result.put(attribute.getKey(), attribute.getValue());
                    break;
            }
        }

        return result;
    }
}