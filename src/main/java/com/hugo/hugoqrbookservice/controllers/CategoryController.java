package com.hugo.hugoqrbookservice.controllers;

import com.hugo.hugoqrbookservice.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @GetMapping("/category")
    public Category getCategory(
        @RequestParam(value = "id", defaultValue = "1") int id
    ) {
        return new Category(id, "test category");
    }
}
