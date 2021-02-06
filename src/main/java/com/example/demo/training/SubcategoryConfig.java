package com.example.demo.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SubcategoryConfig {
    @Bean
    SubcategoryService subcategoryService(SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository){
        return new SubcategoryService(subcategoryRepository, categoryRepository);
    }
}
