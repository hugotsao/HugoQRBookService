package com.hugo.hugoqrbookservice.repository;

import com.hugo.hugoqrbookservice.model.Article;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ArticleRepository extends MongoRepository<Article, String> {

    public Article findFirstByOrderByPublishDateDesc();
}
