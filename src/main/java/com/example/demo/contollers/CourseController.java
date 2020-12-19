package com.example.demo.contollers;

import com.example.demo.repository.CoursesRepository;
import com.example.demo.course.Course;
import com.example.demo.course.CourseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    private CoursesRepository repository;

    public CourseController(CoursesRepository repository) {
        this.repository = repository;
    }

    @PostMapping
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
