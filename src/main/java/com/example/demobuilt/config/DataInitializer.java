package com.example.demobuilt.config;

import com.example.demobuilt.dao.category.CategoryRepository;
import com.example.demobuilt.entities.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.demobuilt.metadata.CategoryEnum.*;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final CategoryRepository categoryRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        CategoryEntity category1 = new CategoryEntity();
        category1.setCategory(RANDOM);

        CategoryEntity category2 = new CategoryEntity();
        category1.setCategory(TECHNOLOGY);

        CategoryEntity category3 = new CategoryEntity();
        category1.setCategory(GENERAL);

        categoryRepository.saveAll(List.of(category1, category2, category3));

    }
}
