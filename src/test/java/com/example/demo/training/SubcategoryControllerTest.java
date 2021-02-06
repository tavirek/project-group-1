package com.example.demo.training;

import com.example.demo.model.Subcategory;
import com.example.demo.training.SubcategoryDTO;
import com.example.demo.training.SubcategoryRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class SubcategoryControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Test
    public void shouldStatusIsOkWhenPostCall() throws Exception {
        //given
        SubcategoryDTO subcategoriesDTO = new SubcategoryDTO();
        String descriptions = "cos";
        String nameSubcategories = "xx";

        //when
        subcategoriesDTO.setDescription(descriptions);
        subcategoriesDTO.setName(nameSubcategories);

        mockMvc.perform(post("/subcategory").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(subcategoriesDTO))).andExpect(status().isOk());

        //then
        assertEquals(1, subcategoryRepository.count());
        Subcategory subcategories = subcategoryRepository.findAll().get(0);
        assertEquals(subcategories.getDescription(), descriptions);
        assertEquals(subcategories.getName(), nameSubcategories);

        MvcResult result = mockMvc.perform(get("/subcategory"))
                .andExpect(status().isOk())
                .andReturn();

        List<SubcategoryDTO> actual = objectMapper.readValue(result.getResponse()
                .getContentAsString(), new TypeReference<>() {
        });
    }
}