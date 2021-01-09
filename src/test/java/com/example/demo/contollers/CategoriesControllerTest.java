package com.example.demo.contollers;

import com.example.demo.category.Category;
import com.example.demo.category.CategoryDTO;
import com.example.demo.category.CategoryRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CategoriesControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryRepository categoriesRepository;

    @Test
    public void statusIsOkWhenPostCall() throws Exception{

        CategoryDTO categoriesDTO = new CategoryDTO();
        String description = "cos";
        String nameCategories = "xx";

        categoriesDTO.setDescription(description);
        categoriesDTO.setNameCategory(nameCategories);

        mockMvc.perform(post("/categories").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(categoriesDTO))).andExpect(status().isOk());

        assertEquals(1,categoriesRepository.count());
        Category categories = categoriesRepository.findAll().get(0);
        assertEquals(categories.getDescription(), description);
        assertEquals(categories.getNameCategory(),nameCategories);

        MvcResult result = mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andReturn();

        List<CategoryDTO> actual = objectMapper.readValue(result.getResponse()
                .getContentAsString(), new TypeReference<List<CategoryDTO>>() {
        });

        assertEquals(actual.get(0).getDescription(), description);
    }



}