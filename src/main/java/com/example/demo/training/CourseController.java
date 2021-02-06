package com.example.demo.training;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/course")
class CourseController {
    private final CourseService courseService;

    CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    void addCourse(@RequestBody CourseDTO courseDTO) {
        courseService.addCourse(courseDTO);
    }

    @GetMapping
    List<CourseDTO> allCourses(){
        return courseService.findAll();
    }

    @GetMapping(path = "/bysubcategory/{subcategoryId}")
    List<CourseDTO> findAllBySubcategory(@PathVariable Long subcategoryId) {return courseService.findAllBySubcategory(subcategoryId);}
}