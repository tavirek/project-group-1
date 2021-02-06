package com.example.demo.training;
import com.example.demo.model.Category;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
class CategoryService {
    private final CategoryRepository categoryRepository;

    CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    boolean addCategory(CategoryDTO categoryDTO) {
        if(categoryDTO.getDescription().length() < 50 ) {
            categoryRepository.save(category(categoryDTO));
            return true;
        } else {
            System.out.println("Nazwa nie może być dłuższa niż 50 znaków");
            return false;
        }
    }

    private Category category(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        return category;
    }

    private CategoryDTO categoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        return categoryDTO;
    }

    List<CategoryDTO> findAll() {
        List<Category> all = categoryRepository.findAll();
        return all.stream()
                .map(this::categoryDTO)
                .collect(Collectors.toList());
    }
}
