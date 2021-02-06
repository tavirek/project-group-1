package com.example.demo.training;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/category")
 class CategoryController {

    private final CategoryService categoriesService;

    CategoryController(CategoryService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @PostMapping
    void addCategories(@RequestBody CategoryDTO categoriesDTO){
        categoriesService.addCategory(categoriesDTO);
    }

    @GetMapping
    List<CategoryDTO> allCategories(){
        return categoriesService.findAll();
    }
}
