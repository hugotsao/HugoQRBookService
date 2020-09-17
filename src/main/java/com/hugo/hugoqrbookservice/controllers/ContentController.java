package com.hugo.hugoqrbookservice.controllers;

import com.hugo.hugoqrbookservice.model.Content;
import lombok.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {
    @GetMapping("/content")
    public Content getArticleContent(
            @RequestParam(value = "articleId")
            @NonNull Integer articleId
    ) {
        return new Content(1, "content");
    }
}
