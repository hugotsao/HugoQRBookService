package com.hugo.hugoqrbookservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
public class DraftContent {
    @Id
    private final String id;
    private final Integer articleId;
    private final String content;
}
