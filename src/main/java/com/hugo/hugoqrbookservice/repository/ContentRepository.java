package com.hugo.hugoqrbookservice.repository;

import com.hugo.hugoqrbookservice.model.Content;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContentRepository extends MongoRepository<Content, String> {
    public Content findByArticleId(Integer articleId);
}
