package com.example.demo.category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(CategoryDTO categoryDTO) {
        if(categoryDTO.getDescription().length() < 50 ) {
            categoryRepository.save(category(categoryDTO));
        }
    }

    private Category category(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getNameCategory());
        category.setDescription(categoryDTO.getDescription());
        return category;
    }

    private CategoryDTO categoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(category.getName());
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
