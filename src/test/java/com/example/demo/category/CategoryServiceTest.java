package com.example.demo.category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void shouldNotAddCategoryDescriptionIsNoLongerThen50Characters() {
        //given
        CategoryDTO categoryDTO = new CategoryDTO();
        String name = "nazwa kategorii";
        String description = "opis kategorii";
        categoryDTO.setDescription(description);
        categoryDTO.setName(name);

        //when
        categoryService.addCategory(categoryDTO);

        //then
        assertEquals(1, categoryRepository.count());
        Category categories = categoryRepository.findAll().get(0);
        assertEquals(categories.getDescription(), description);
        assertEquals(categories.getName(), name);
    }

    @Test
    public void shouldNotAddCategoryDescriptionIsLongerThen50Characters() {
        //given
        CategoryDTO categoryDTO = new CategoryDTO();
        String name = "nazwa kategorii";
        String description = "opis kategorii który ma więcej niż 50 znaków!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
        categoryDTO.setDescription(description);
        categoryDTO.setName(name);
        //when
        categoryService.addCategory(categoryDTO);

        //then
        assertEquals(0, categoryRepository.count());
    }
}