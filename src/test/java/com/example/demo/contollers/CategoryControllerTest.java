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
class CategoryControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void shouldStatusIsOkWhenPostCall() throws Exception {

        //given
        CategoryDTO categoryDTO = new CategoryDTO();
        String description = "cos";
        String name = "xx";

        //when
        categoryDTO.setDescription(description);
        categoryDTO.setName(name);

        mockMvc.perform(post("/category").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(categoryDTO))).andExpect(status().isOk());

        //then
        assertEquals(1, categoryRepository.count());
        Category categories = categoryRepository.findAll().get(0);
        assertEquals(categories.getDescription(), description);
        assertEquals(categories.getName(), name);

        MvcResult result = mockMvc.perform(get("/category"))
                .andExpect(status().isOk())
                .andReturn();

        List<CategoryDTO> actual = objectMapper.readValue(result.getResponse()
                .getContentAsString(), new TypeReference<List<CategoryDTO>>() {
        });

        assertEquals(actual.get(0).getDescription(), description);
    }
}