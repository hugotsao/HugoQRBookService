package com.hugo.hugoqrbookservice.controllers;

import com.hugo.hugoqrbookservice.model.Content;
import com.hugo.hugoqrbookservice.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
public class ContentController {
    @Autowired
    ContentRepository contentRepository;

    @GetMapping("/content/{articleId}")
    public Content getContentById(@PathVariable int articleId) {
        return contentRepository.findByArticleId(articleId);
    }

    @PostMapping("/content")
    public Content addContent(@RequestBody Content newContent) {
        return this.contentRepository.insert(newContent);
    }

    @PutMapping("/content")
    public Content updateContent(@RequestBody Content newContent) {
        return contentRepository.save(newContent);
    }
    @DeleteMapping("/content/{articleId}")
    public void deleteContent(@PathVariable Integer articleId) {
        Content article = this.contentRepository.findByArticleId(articleId);
        if (article != null) {
            this.contentRepository.delete(article);
        }
    }
}
