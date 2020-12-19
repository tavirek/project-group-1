package com.example.demo.course;

import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @GetMapping
    public List<CourseDTO> allCourses(){
        return courseService.findAll();
    }
}