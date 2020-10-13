package com.hugo.hugoqrbookservice.controllers;

import com.hugo.hugoqrbookservice.model.Article;
import com.hugo.hugoqrbookservice.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

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
        Article articleToDelete = this.articleRepository.findByArticleId(articleId);
        if (articleToDelete != null){
            this.articleRepository.delete(articleToDelete);
        }
    }
}
