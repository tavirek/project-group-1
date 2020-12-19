package com.example.demo;

import com.example.demo.course.Course;
import com.example.demo.course.CourseDTO;
import com.example.demo.repository.CoursesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProjectGroup1ApplicationTests {

    @Autowired
    CoursesRepository coursesRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRepository() {
        Course course1 = new Course("course1", 5);
        Course course2 = new Course("course2", 6);
        Course course3 = new Course("course3", 7);

        Course savedCourse1 = coursesRepository.save(course1);
        Course savedCourse2 = coursesRepository.save(course2);
        Course savedCourse3 = coursesRepository.save(course3);

        List<Course> allCourses = coursesRepository.findAll();
        assertThat(allCourses).isNotEmpty();
    }


}
