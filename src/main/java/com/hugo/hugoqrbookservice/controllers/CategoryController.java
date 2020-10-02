package com.hugo.hugoqrbookservice.controllers;

import com.hugo.hugoqrbookservice.model.Category;
import com.hugo.hugoqrbookservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("/category")
    public Category addCategory(Category newCategory) {
        return categoryRepository.insert(newCategory);
    }
}
