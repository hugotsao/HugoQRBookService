package com.hugo.hugoqrbookservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "categories")
public class Category {
    @MongoId
    private String categoryId;
    private String categoryName;
}
