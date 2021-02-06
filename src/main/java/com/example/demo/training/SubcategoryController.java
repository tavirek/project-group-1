package com.example.demo.training;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/subcategory")
class SubcategoryController {

    private final SubcategoryService subcategoryService;

    SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @PostMapping
    void addSubcategory(@RequestBody SubcategoryDTO subcategoryDTO) {
        subcategoryService.addSubcategory(subcategoryDTO);
    }

    @GetMapping
    List<SubcategoryDTO> allSubcategory() {
        return subcategoryService.findAll();
    }

    @GetMapping(path = "/bycategory/{categoryId}")
    List<SubcategoryDTO> findAllByCategory(@PathVariable Long categoryId) {return subcategoryService.findAllByCategory(categoryId);}
}