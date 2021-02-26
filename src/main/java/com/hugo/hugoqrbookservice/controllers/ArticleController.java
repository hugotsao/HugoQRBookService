package com.hugo.hugoqrbookservice.controllers;

import com.hugo.hugoqrbookservice.model.Article;
import com.hugo.hugoqrbookservice.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/api/articles/get")
    public ResponseEntity<List<Article>> getArticles() {
        return ResponseEntity.of(Optional.of(articleRepository.findAllByOrderByPublishDateDesc()));
    }

    @GetMapping("/api/articles/latest/get")
    public ResponseEntity<Article> getLatestArticle() {
        List<Article> allArticles = this.articleRepository.findAllByOrderByPublishDateDesc();
        if (allArticles.size() == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allArticles.get(0));
    }
    @GetMapping("/api/article/{articleId}/get")
    public Article getArticle(@PathVariable String articleId) {
        if("latest".equals(articleId)){
            List<Article> allArticles = this.articleRepository.findAllByOrderByPublishDateDesc();
            return allArticles.size() > 0 ? allArticles.get(0) : null;
        }
        return articleRepository.findById(articleId).get();
    }
    @PostMapping("/api/article/add")
    public Article addArticle(@RequestBody Article newArticle){
        return this.articleRepository.insert(newArticle);
    }

    @PutMapping("/api/article/update")
    public Article updateArticle(@RequestBody Article newArticle) {
        return this.articleRepository.save(newArticle);
    }
    @DeleteMapping("/api/article/{articleId}/delete")
    public void deleteArticle(@PathVariable
                              String articleId){
        this.articleRepository.deleteById(articleId);
    }
}
