package com.hugo.hugoqrbookservice.repository;

import com.hugo.hugoqrbookservice.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200, http://localhost")
public interface CategoryRepository extends MongoRepository<Category, String> {
    Category findByCategoryId(int categoryId);
}
