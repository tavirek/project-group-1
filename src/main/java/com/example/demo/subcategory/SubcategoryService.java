package com.example.demo.subcategory;
import java.util.List;
import java.util.stream.Collectors;

public class SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;

    public SubcategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    public void addSubcategory(SubcategoryDTO subcategoryDTO) {
        subcategoryRepository.save(subcategory(subcategoryDTO));
    }

    private Subcategory subcategory(SubcategoryDTO subcategoryDTO) {
        Subcategory subcategory = new Subcategory();
        subcategory.setNameSubcategory(subcategoryDTO.getNameSubcategory());
        subcategory.setDescription(subcategoryDTO.getDescription());
        return subcategory;
    }

    private SubcategoryDTO subcategoryDTO(Subcategory subcategory) {
        SubcategoryDTO subcategoryDTO = new SubcategoryDTO();
        subcategoryDTO.setNameSubcategory(subcategory.getNameSubcategory());
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
