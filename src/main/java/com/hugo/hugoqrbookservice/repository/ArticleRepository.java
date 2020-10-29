package com.hugo.hugoqrbookservice.repository;

import com.hugo.hugoqrbookservice.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ArticleRepository extends MongoRepository<Article, String> {
    List<Article> findAllByOrderByPublishDateDesc();
}
