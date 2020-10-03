package com.hugo.hugoqrbookservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Content {
    @Id
    private String id;
    private final Integer articleId;
    private final String content;
}
