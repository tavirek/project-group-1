package com.example.demo.subcategory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubcategoryConfig {
    @Bean
    public SubcategoryService subcategoryService(SubcategoryRepository subcategoryRepository){
        return new SubcategoryService(subcategoryRepository);
    }
}
