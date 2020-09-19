package com.hugo.hugoqrbookservice.repository;

import com.hugo.hugoqrbookservice.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
    Category findByCategoryId(int categoryId);
}
