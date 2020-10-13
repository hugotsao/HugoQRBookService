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

    @PostMapping("/category")
    public Category addCategory(@RequestBody Category newCategory) {
        return this.categoryRepository.insert(newCategory);
    }
    @PutMapping("/category")
    public Category updateCategory(@RequestBody Category newCategory) {
        return categoryRepository.save(newCategory);
    }
    @DeleteMapping("/category/{categoryName}")
    public void deleteCategory(@PathVariable String categoryName) {
        Category category = this.categoryRepository.findByCategoryName(categoryName);
        if(category != null) {
            this.categoryRepository.delete(category);
        }
    }
}
