package com.hugo.hugoqrbookservice.repository;

import com.hugo.hugoqrbookservice.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

public interface ArticleRepository extends MongoRepository<Article, String> {
    List<Article> findAllByOrderByPublishDateDesc();
}
