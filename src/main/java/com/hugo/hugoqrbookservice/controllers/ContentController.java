package com.hugo.hugoqrbookservice.controllers;

import com.hugo.hugoqrbookservice.model.Content;
import com.hugo.hugoqrbookservice.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
public class ContentController {
    @Autowired
    ContentRepository contentRepository;

    @GetMapping("/api/contents/get")
    public List<Content> getContents() {
        return this.contentRepository.findAll();
    }

    @GetMapping("/api/content/{articleId}/get")
    public Content getContentById(@PathVariable String articleId) {
        return contentRepository.findByArticleId(articleId);
    }
    @PostMapping("/api/content/add")
    public Content addContent(@RequestBody Content newContent) {
        return this.contentRepository.insert(newContent);
    }

    @PutMapping("/api/content/update")
    public Content updateContent(@RequestBody Content newContent) {
        return contentRepository.save(newContent);
    }

    @DeleteMapping("/api/content/{articleId}/delete")
    public void deleteContent(@PathVariable String articleId) {
        this.contentRepository.deleteById(articleId);
    }
}
