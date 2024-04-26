package com.example.demobuilt.metadata.dto;

import com.example.demobuilt.entities.CategoryEntity;
import com.example.demobuilt.metadata.CategoryEnum;

public record CategoryDTO(Long id, CategoryEnum categoryEnum) {

    public CategoryDTO(CategoryEntity categoryEntity) {
        this(categoryEntity.getId(), categoryEntity.getCategory());
    }
}
