package com.example.demo.subcategory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubcategoryServiceTest {

    @Autowired
    private SubcategoryService subcategoryService ;

    @Autowired
    private SubcategoryRepository subcategoryRepository ;

    @Test
    public void shouldAddSubcategoryDescriptionIsNoLongerThen200Characters() {
        //given
        SubcategoryDTO subcategoryDTO = new SubcategoryDTO();
        String name = "nazwa kategorii";
        String description = "opis kategorii";
        subcategoryDTO.setDescription(description);
        subcategoryDTO.setName(name);

        //when
        subcategoryService.addSubcategory(subcategoryDTO);

        //then
        assertEquals(1, subcategoryRepository.count());
        Subcategory subcategory = subcategoryRepository.findAll().get(0);
        assertEquals(subcategory.getDescription(), description);
        assertEquals(subcategory.getName(), name);
    }

    @Test
    public void shouldAddSubcategoryDescriptionIsLongerThen200Characters() {
        //given
        SubcategoryDTO subcategoryDTO = new SubcategoryDTO();
        String name = "nazwa kategorii";
        String description = "opis kategorii który ma więcej niż 200 znaków!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +
                "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +
                "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
        subcategoryDTO.setDescription(description);
        subcategoryDTO.setName(name);
        //when
        subcategoryService.addSubcategory(subcategoryDTO);

        //then
        assertEquals(0, subcategoryRepository.count());
    }

}