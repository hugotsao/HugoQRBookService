package com.hugo.hugoqrbookservice.repository;

import com.hugo.hugoqrbookservice.model.DraftContent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DraftContentRepository extends MongoRepository<DraftContent, String> {
    DraftContent findByArticleId(Integer articleId);
}
