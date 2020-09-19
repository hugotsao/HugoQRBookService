package com.hugo.hugoqrbookservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Data
public class DraftArticle {
    @Id
    private final String id;
    private final Integer articleId;
    private final Integer categoryId;
    private final String title;
    private final List<String> tags;
    private final List<String> references;
    private final Date modifiedDate;
}
