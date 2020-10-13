package com.hugo.hugoqrbookservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "draftArticles")
public class DraftArticle {
    @Id
    private String draftArticleid;
    private String articleId;
    private String categoryId;
    private String title;
    private List<String> tags;
    private List<String> references;
    private Date modifiedDate;
}
