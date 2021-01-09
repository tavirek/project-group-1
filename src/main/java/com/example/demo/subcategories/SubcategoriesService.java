package com.example.demo.subcategories;

import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class SubcategoriesService {
    private final SubcategoriesRepository subcategoriesRepository;

    public SubcategoriesService(SubcategoriesRepository subcategoriesRepository) {
        this.subcategoriesRepository = subcategoriesRepository;
    }

    public void addSubcategories(SubcategoriesDTO subcategoriesDTO) {
        subcategoriesRepository.save(subcategories(subcategoriesDTO));
    }

    private Subcategories subcategories(SubcategoriesDTO subcategoriesDTO) {
        Subcategories subcategories = new Subcategories();
        subcategories.setNameSubcategories(subcategoriesDTO.getNameSubcategories());
        subcategories.setDescription(subcategoriesDTO.getDescription());
        return subcategories;
    }

    private SubcategoriesDTO subcategoriesDTO(Subcategories subcategories) {
        SubcategoriesDTO subcategoriesDTO = new SubcategoriesDTO();
        subcategoriesDTO.setNameSubcategories(subcategories.getNameSubcategories());
        subcategoriesDTO.setDescription(subcategories.getDescription());
        return subcategoriesDTO;
    }

    public List<SubcategoriesDTO> findAll() {
        List<Subcategories> all = subcategoriesRepository.findAll();
        return all.stream()
                .map(this::subcategoriesDTO)
                .collect(Collectors.toList());
    }
}
