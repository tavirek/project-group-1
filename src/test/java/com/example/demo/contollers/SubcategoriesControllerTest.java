package com.example.demo.contollers;

import com.example.demo.subcategory.Subcategory;
import com.example.demo.subcategory.SubcategoryDTO;
import com.example.demo.subcategory.SubcategoryRepository;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SubcategoriesControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Test

    public void shouldAddSubcategories() throws Exception {
        //given

        SubcategoryDTO subcategoriesDTO = new SubcategoryDTO();
        String descriptions = "cos";
        String nameSubcategories = "xx";

        subcategoriesDTO.setDescription(descriptions);
        subcategoriesDTO.setNameSubcategory(nameSubcategories);

        mockMvc.perform(post("/subcategories").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(subcategoriesDTO))).andExpect(status().isOk());

        assertEquals(1, subcategoryRepository.count());
        Subcategory subcategories = subcategoryRepository.findAll().get(0);
        assertEquals(subcategories.getDescription(), descriptions);
        assertEquals(subcategories.getNameSubcategory(), nameSubcategories);

        MvcResult result = mockMvc.perform(get("/subcategories"))
                .andExpect(status().isOk())
                .andReturn();

        List<SubcategoryDTO> actual = objectMapper.readValue(result.getResponse()
                .getContentAsString(), new TypeReference<List<SubcategoryDTO>>() {
        });
    }
}