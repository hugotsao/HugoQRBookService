package com.hugo.hugoqrbookservice.controllers;

import com.hugo.hugoqrbookservice.model.Article;
import com.hugo.hugoqrbookservice.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/articles")
    public List<Article> getArticles() {
        return articleRepository.findAllByOrderByPublishDateDesc();
    }

    @GetMapping("/article/{articleId}")
    public Article getArticleById(@PathVariable String articleId) {
        if ("latest".equals(articleId)) {
            List<Article> articles = this.getArticles();
            Article latestArticles = articles.size() > 0 ? articles.get(0) : null;
            return latestArticles;
        }
        return this.articleRepository.findByArticleId(articleId);
    }
    @PostMapping("/article")
    public Article addArticle(@RequestBody Article newArticle){
        return this.articleRepository.insert(newArticle);
    }

    @PutMapping("/article")
    public Article updateArticle(@RequestBody Article newArticle) {
        return this.articleRepository.save(newArticle);
    }
    @DeleteMapping("/article/{articleId}")
    public void deleteArticle(@PathVariable
                              String articleId){
        this.articleRepository.deleteById(articleId);
    }
}
