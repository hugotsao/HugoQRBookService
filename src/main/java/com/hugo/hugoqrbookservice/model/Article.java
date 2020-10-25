package com.hugo.hugoqrbookservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "articles")
public class Article {
    @MongoId
    private String articleId;
    private String categoryId;
    private String title;
    private List<String> tags;
    private List<String> references;
    private Date publishDate;
    private Date modifiedDate;
}
