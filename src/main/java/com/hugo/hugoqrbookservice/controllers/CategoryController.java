package com.hugo.hugoqrbookservice.controllers;

import com.hugo.hugoqrbookservice.model.Category;
import com.hugo.hugoqrbookservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/api/categories/get")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("/api/category/add")
    public Category addCategory(@RequestBody Category newCategory) {
        return this.categoryRepository.insert(newCategory);
    }
    @PutMapping("/api/category/update")
    public Category updateCategory(@RequestBody Category newCategory) {
        return categoryRepository.save(newCategory);
    }
    @DeleteMapping("/api/category/{categoryName}/delete")
    public void deleteCategory(@PathVariable String categoryName) {
        Category category = this.categoryRepository.findByCategoryName(categoryName);
        if(category != null) {
            this.categoryRepository.delete(category);
        }
    }
}
