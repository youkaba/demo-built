package com.example.demobuilt.dao.post;

import com.example.demobuilt.entities.PostEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    @Query("from PostEntity post where post.id =  :id")
    @EntityGraph(attributePaths = "categoryEntity")
    PostEntity fetchByID(@Param("id") Long id);


    @Query("from PostEntity post")
    @EntityGraph(attributePaths = "categoryEntity")
    List<PostEntity> fetchAll();
}
