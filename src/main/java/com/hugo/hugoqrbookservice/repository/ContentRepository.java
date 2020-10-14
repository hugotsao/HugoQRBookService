package com.hugo.hugoqrbookservice.repository;

import com.hugo.hugoqrbookservice.model.Content;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface ContentRepository extends MongoRepository<Content, String> {
    Content findByArticleId(String articleId);
}
