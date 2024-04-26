package com.example.demobuilt.dao.post;

import com.example.demobuilt.dao.category.CategoryRepository;
import com.example.demobuilt.entities.CategoryEntity;
import com.example.demobuilt.entities.PostEntity;
import com.example.demobuilt.metadata.PostPayload;
import com.example.demobuilt.metadata.UpdatePayload;
import com.example.demobuilt.metadata.dto.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PostJpaRepository implements PostRepositoryJpa {

    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;
    @Override
    public PostDTO addPost(PostPayload payload) {
        CategoryEntity category = categoryRepository.getReferenceById(payload.categoryId());
        PostEntity postEntity = PostEntity.builder()
                .categoryEntity(category)
                .content(payload.content())
                .title(payload.title())
                .dateTime(LocalDateTime.now())
                .build();
        PostEntity newPost = postRepository.save(postEntity);

        return new PostDTO(newPost.getId(), newPost.getTitle(), newPost.getContent(), newPost.getDateTime(), payload.categoryId());
    }

    @Override
    public PostDTO fetchById(Long id) {
        return postRepository.fetchByID(id).toDto();
    }

    @Override
    public List<PostDTO> findAll() {
        return postRepository.fetchAll()
                .stream()
                .map(PostEntity::toDto)
                .toList();
    }

    @Override
    public PostDTO updatePost(Long postId, UpdatePayload updatedPost) {
        PostEntity postEntity = postRepository.fetchByID(postId);
        postEntity.setTitle(updatedPost.title());
        postEntity.setContent(updatedPost.Content());

        return postEntity.toDto();
    }
}
