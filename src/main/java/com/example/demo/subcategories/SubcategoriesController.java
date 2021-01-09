package com.example.demo.subcategories;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/subcategories")
public class SubcategoriesController {

    private final SubcategoriesService subcategoriesService;

    public SubcategoriesController(SubcategoriesService subcategoriesService) {
        this.subcategoriesService = subcategoriesService;
    }

    @PostMapping
    void addSubcategories(@RequestBody SubcategoriesDTO subcategoriesDTO) {
        subcategoriesService.addSubcategories(subcategoriesDTO);
    }

    @GetMapping
    public List<SubcategoriesDTO> allCategories() {
        return subcategoriesService.findAll();
    }
}