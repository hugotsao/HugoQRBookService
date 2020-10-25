package com.hugo.hugoqrbookservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "contents")
public class Content {
    @MongoId
    private String articleId;
    private String content;
}
