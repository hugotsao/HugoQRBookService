package com.hugo.hugoqrbookservice.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Article {
    private final Integer id;
    private final Integer categoryId;
    private final String title;
    private final List<String> tags;
    private final List<String> references;
    private final Date publishDate;
    private final Date modifiedDate;
}
