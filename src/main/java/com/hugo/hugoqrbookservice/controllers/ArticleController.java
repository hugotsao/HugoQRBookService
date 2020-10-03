package com.hugo.hugoqrbookservice.controllers;

import com.hugo.hugoqrbookservice.model.Article;
import com.hugo.hugoqrbookservice.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/articles")
    public List<Article> getArticles() {
        return articleRepository.findAll(Sort.by(Sort.Direction.DESC, "publishDate"));
    }
    @GetMapping("/articles/genNewArticleId")
    public Integer getLatestArticleId() {
        List<Article> articles = articleRepository.findAll(Sort.by(Sort.Direction.DESC, "articleId"));
        if (articles != null && articles.size() > 0) {
            return articles.get(0).getArticleId() + 1;
        }
        return 1;
    }
}
