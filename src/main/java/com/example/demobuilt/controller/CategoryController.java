package com.example.demobuilt.controller;

import com.example.demobuilt.dao.category.CategoryRepository;
import com.example.demobuilt.metadata.dto.CategoryDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        var categories = categoryRepository.findAll()
                .stream()
                .map(CategoryDTO::new)
                .toList();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
