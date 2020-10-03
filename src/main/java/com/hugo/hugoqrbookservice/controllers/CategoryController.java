package com.hugo.hugoqrbookservice.controllers;

import com.hugo.hugoqrbookservice.model.Category;
import com.hugo.hugoqrbookservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/category")
    public Category addOrUpdateCategory(Category newCategory) {
        Category oldCategory = this.categoryRepository.findByName(newCategory.getName());
        if (oldCategory != null) {
            return oldCategory;
        }
        return categoryRepository.save(newCategory);
    }
    @DeleteMapping("/category/{categoryName}")
    public void deleteCategory(@PathVariable String categoryName) {
        Category category = this.categoryRepository.findByName(categoryName);
        if(category != null) {
            this.categoryRepository.delete(category);
        }
    }
}
