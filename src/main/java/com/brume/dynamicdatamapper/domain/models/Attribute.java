package com.brume.dynamicdatamapper.domain.models;

import java.util.Map;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data @Entity @NoArgsConstructor
public class Attribute {

    @Id

    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    private String key;

    @Nullable
    private String value;

    @Nullable
    private int numericValue;

    private String type;

    @ManyToOne
    @JoinColumn(name = "entry_id", nullable = false)
    private Entry entry;

    public static Attribute fromMapEntry(Entry entry, Map.Entry<String, Object> attributeMap) {
        Attribute attribute = new Attribute();
        attribute.setKey(attributeMap.getKey());

        attribute.setProvider(entry.getProvider());
        attribute.setEntry(entry);

        if (attributeMap.getValue() instanceof Integer) {
            attribute.setType("integer");
            attribute.setNumericValue(Integer.parseInt (String.valueOf(attributeMap.getValue())));
        } else {
            attribute.setType("string");
            attribute.setValue(String.valueOf(attributeMap.getValue()));
        }

        return attribute;

    }
}