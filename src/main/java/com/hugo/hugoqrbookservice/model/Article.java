package com.hugo.hugoqrbookservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "articles")
public class Article {
    @Id
    private String articleId;
    private String categoryId;
    private String title;
    private List<String> tags;
    private List<String> references;
    private Date publishDate;
    private Date modifiedDate;
    private String content;
}
