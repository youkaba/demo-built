package com.example.demobuilt.entities;

import com.example.demobuilt.metadata.CategoryEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @OneToMany(cascade = ALL, mappedBy = "categoryEntity", orphanRemoval = true)
    private Set<PostEntity> postEntities;

    private void addPost(PostEntity postEntity) {
        postEntities.add(postEntity);
        postEntity.setCategoryEntity(this);
    }

}
