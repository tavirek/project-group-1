package com.example.demo.training;

import com.example.demo.model.Course;
import com.example.demo.training.CourseDTO;
import com.example.demo.training.CoursesRepository;
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
class CourseControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CoursesRepository coursesRepository;

    @Test
    public void statusIsOkWhenPostCall() throws Exception {
        //given
        CourseDTO courseDTO = new CourseDTO();
        String courseDescription = "cos";
        String courseTitle = "xx";
        int courseDuration = 2;

        courseDTO.setDescription(courseDescription);
        courseDTO.setTitle(courseTitle);
        courseDTO.setDuration(courseDuration);

        mockMvc.perform(post("/course").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(courseDTO))).andExpect(status().isOk());

        assertEquals(1, coursesRepository.count());
        Course course = coursesRepository.findAll().get(0);
        assertEquals(course.getDescription(), courseDescription);
        assertEquals(course.getDuration(), courseDuration);
        assertEquals(course.getTitle(),courseTitle);

        MvcResult result = mockMvc.perform(get("/course"))
                .andExpect(status().isOk())
                .andReturn();

        List<CourseDTO> actual = objectMapper.readValue(result.getResponse()
                .getContentAsString(), new TypeReference<List<CourseDTO>>() {
        });

        assertEquals(actual.get(0).getDescription(), courseDescription);
        assertEquals(actual.get(0).getDuration(), courseDuration);
    }
}