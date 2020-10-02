package com.hugo.hugoqrbookservice.repository;

import com.hugo.hugoqrbookservice.model.DraftArticle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DraftArticleRepository extends MongoRepository<DraftArticle, String> {
}
