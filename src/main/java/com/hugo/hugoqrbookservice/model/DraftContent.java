package com.hugo.hugoqrbookservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "draftContents")
public class DraftContent {
    @Id
    private String articleId;
    private String content;
}
