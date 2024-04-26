package com.example.demobuilt.controller;

import com.example.demobuilt.metadata.PostPayload;
import com.example.demobuilt.metadata.UpdatePayload;
import com.example.demobuilt.metadata.dto.PostDTO;
import com.example.demobuilt.services.BlogPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("api/v1/posts")
public record BlogPostController(BlogPostService blogPostService) {
    @PostMapping("/add")
    @ResponseStatus(CREATED)
    public PostDTO createPost(@RequestBody PostPayload postPayload) {
        return blogPostService.addPost(postPayload);
    }

    @PutMapping("/{postId}")
    public PostDTO updatePost(@PathVariable Long postId, @RequestBody UpdatePayload updatedPost) {
        return blogPostService.updatePost(postId, updatedPost);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public PostDTO getPostById(@PathVariable Long id) {
        return blogPostService.searchById(id);
    }

    @GetMapping
    public List<PostDTO> retrieveAll() {
        return blogPostService.fetchAll();
    }



}
