package com.example.demobuilt.dao.post;

import com.example.demobuilt.metadata.PostPayload;
import com.example.demobuilt.metadata.UpdatePayload;
import com.example.demobuilt.metadata.dto.PostDTO;

import java.util.List;

public interface PostRepositoryJpa {

    PostDTO addPost(PostPayload postPayload);

    PostDTO fetchById(Long id);

    List<PostDTO> findAll();

    PostDTO updatePost(Long postId, UpdatePayload updatedPost);
}
