package com.hugo.hugoqrbookservice.repository;

import com.hugo.hugoqrbookservice.model.DraftContent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface DraftContentRepository extends MongoRepository<DraftContent, String> {
    DraftContent findByArticleId(Integer articleId);
}
