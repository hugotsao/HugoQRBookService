package com.hugo.hugoqrbookservice.controllers;

import com.hugo.hugoqrbookservice.model.Article;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class ArticleController {
    @GetMapping("/article")
    public Article getArticleById(
            @RequestParam(value = "articleId") Integer articleId
    ) {
        return Article.builder()
                .id(1)
                .categoryId(1)
                .title("test title")
                .tags(new ArrayList<>())
                .references(new ArrayList<>())
                .publishDate(new Date())
                .modifiedDate(new Date())
                .build();
    }
}
