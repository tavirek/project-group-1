package com.example.demo.contollers;

import com.example.demo.course.CourseDTO;
import com.example.demo.repository.CoursesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CourseController courseController;

    @Autowired
    private CoursesRepository coursesRepository;

    @Test
    public void statusIsOkWhenPostCall() throws Exception {
        //given
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setDescription("cos");
        courseDTO.setTitle("xx");
        courseDTO.setDuration(2);

        mockMvc.perform(post("/course").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(courseDTO))).andExpect(status().isOk());

        assertEquals(1,coursesRepository.count());
    }
}