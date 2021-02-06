package com.example.demo.training;

import com.example.demo.model.Subcategory;
import com.example.demo.training.SubcategoryDTO;
import com.example.demo.training.SubcategoryRepository;
import com.example.demo.training.SubcategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SubcategoryServiceTest {

    @Autowired
    private SubcategoryService subcategoryService ;

    @Autowired
    private SubcategoryRepository subcategoryRepository ;

    @Test
    public void shouldNotAddSubcategoryDescriptionIsNoLongerThen200Characters() {
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
    public void shouldNotAddSubcategoryDescriptionIsLongerThen200Characters() {
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