package com.example.demo.contollers;

import com.example.demo.course.CourseDTO;
import com.example.demo.services.CourseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    void addCourse(@RequestBody CourseDTO courseDTO) {
        courseService.addCourse(courseDTO);
    }
}