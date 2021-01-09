package com.example.demo.category;

import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategories(CategoryDTO categoryDTO) {
        categoryRepository.save(category(categoryDTO));
    }

    private Category category(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setNameCategory(categoryDTO.getNameCategory());
        category.setDescription(categoryDTO.getDescription());
        return category;
    }

    private CategoryDTO categoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setNameCategory(category.getNameCategory());
        categoryDTO.setDescription(category.getDescription());
        return categoryDTO;
    }

    public List<CategoryDTO> findAll() {
        List<Category> all = categoryRepository.findAll();
        return all.stream()
                .map(this::categoryDTO)
                .collect(Collectors.toList());
    }
}
