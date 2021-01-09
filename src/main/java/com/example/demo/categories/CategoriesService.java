package com.example.demo.categories;


import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class CategoriesService {

    private final CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public void addCategories(CategoriesDTO categoriesDTO){
        categoriesRepository.save(categories(categoriesDTO));
    }

    private Categories categories(CategoriesDTO categoriesDTO) {
        Categories categories = new Categories();
        categories.setNameCategories(categoriesDTO.getNameCategories());
        categories.setDescription(categoriesDTO.getDescription());
        return categories;
    }

    private CategoriesDTO categoriesDTO(Categories categories){
        CategoriesDTO categoriesDTO = new CategoriesDTO();
        categoriesDTO.setNameCategories(categories.getNameCategories());
        categoriesDTO.setDescription(categories.getDescription());
        return  categoriesDTO;
    }

    public List<CategoriesDTO> findAll(){
        List<Categories> all =categoriesRepository.findAll();
        return all.stream()
                .map(this::categoriesDTO)
                .collect(Collectors.toList());
    }
}
