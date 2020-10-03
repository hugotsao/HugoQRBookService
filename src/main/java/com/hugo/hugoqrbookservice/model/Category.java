package com.hugo.hugoqrbookservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Category {
    @Id private String id;
    private final Integer categoryId;
    private final String name;
}
