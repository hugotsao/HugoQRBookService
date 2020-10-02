package com.hugo.hugoqrbookservice.repository;

import com.hugo.hugoqrbookservice.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, String> {
}
