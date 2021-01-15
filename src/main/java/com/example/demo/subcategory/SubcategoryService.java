package com.example.demo.subcategory;

import java.util.List;
import java.util.stream.Collectors;

public class SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;

    public SubcategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    public boolean addSubcategory(SubcategoryDTO subcategoryDTO) {
        if (subcategoryDTO.getDescription().length() < 200) {
            subcategoryRepository.save(subcategory(subcategoryDTO));
            return true;
        } else  {
            System.out.println("Opis nie może być dłuższy niż 200 znaków");
            return false;
        }
    }

    private Subcategory subcategory(SubcategoryDTO subcategoryDTO) {
        Subcategory subcategory = new Subcategory();
        subcategory.setName(subcategoryDTO.getName());
        subcategory.setDescription(subcategoryDTO.getDescription());
        return subcategory;
    }

    private SubcategoryDTO subcategoryDTO(Subcategory subcategory) {
        SubcategoryDTO subcategoryDTO = new SubcategoryDTO();
        subcategoryDTO.setName(subcategory.getName());
        subcategoryDTO.setDescription(subcategory.getDescription());
        return subcategoryDTO;
    }

    public List<SubcategoryDTO> findAll() {
        List<Subcategory> all = subcategoryRepository.findAll();
        return all.stream()
                .map(this::subcategoryDTO)
                .collect(Collectors.toList());
    }
}
