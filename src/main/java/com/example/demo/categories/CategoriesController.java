package com.example.demo.categories;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/categories")
public class CategoriesController {

    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @PostMapping
    void addCategories(@RequestBody CategoriesDTO categoriesDTO){
        categoriesService.addCategories(categoriesDTO);
    }

    @GetMapping
    public List<CategoriesDTO> allCategories(){
        return categoriesService.findAll();
    }
}
