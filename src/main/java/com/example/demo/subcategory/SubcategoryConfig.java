package com.example.demo.subcategory;

import com.example.demo.category.CategoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubcategoryConfig {
    @Bean
    public SubcategoryService subcategoryService(SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository){
        return new SubcategoryService(subcategoryRepository, categoryRepository);
    }
}
