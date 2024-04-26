package com.example.demobuilt.services;

import com.example.demobuilt.dao.post.PostRepositoryJpa;
import com.example.demobuilt.metadata.PostPayload;
import com.example.demobuilt.metadata.UpdatePayload;
import com.example.demobuilt.metadata.dto.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BlogPostService {
    private final PostRepositoryJpa postRepository;

    @Transactional
    public PostDTO addPost(PostPayload postPayload) {
        return postRepository.addPost(postPayload);
    }

    public PostDTO searchById(Long id) {
        return postRepository.fetchById(id);
    }

    public List<PostDTO> fetchAll() {
        return postRepository.findAll();
    }

    @Transactional
    public PostDTO updatePost(Long postId, UpdatePayload updatedPost) {
        return postRepository.updatePost(postId, updatedPost);
    }
}
