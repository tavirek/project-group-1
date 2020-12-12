package com.example.demo.training;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    private CoursesRepository repository;

    public CourseController(CoursesRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/course")
    void addCourse(@RequestBody CourseDTO course) {
        repository.save(course(course));
    }

    private Course course(CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setDuration(courseDTO.getDuration());
        course.setDescription(courseDTO.getDescription());
        return course;
    }

}
