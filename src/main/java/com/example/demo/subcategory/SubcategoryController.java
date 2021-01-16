package com.example.demo.subcategory;
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
}