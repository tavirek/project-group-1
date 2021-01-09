package com.example.demo.category;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoriesService;

    public CategoryController(CategoryService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @PostMapping
    void addCategories(@RequestBody CategoryDTO categoriesDTO){
        categoriesService.addCategories(categoriesDTO);
    }

    @GetMapping
    public List<CategoryDTO> allCategories(){
        return categoriesService.findAll();
    }
}
