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
    @PutMapping("/content/")
    public void addOrUpdateContent(@RequestBody Content newContent) {
        Content oldContent = contentRepository.findByArticleId(newContent.getArticleId());
        if(oldContent != null) {
            newContent.setId(oldContent.getId());
        }
        contentRepository.save(newContent);
    }
}
