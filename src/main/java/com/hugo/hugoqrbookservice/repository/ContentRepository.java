package com.hugo.hugoqrbookservice.repository;

import com.hugo.hugoqrbookservice.model.Content;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
public interface ContentRepository extends MongoRepository<Content, String> {
    public Content findByArticleId(Integer articleId);
}
