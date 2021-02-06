package com.example.demo.training;

import com.example.demo.model.Course;
import com.example.demo.model.Subcategory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class CourseService {

    private final CoursesRepository coursesRepository;

    private final SubcategoryRepository subcategoryRepository;

    CourseService(CoursesRepository coursesRepository, SubcategoryRepository subcategoryRepository) {
        this.coursesRepository = coursesRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    void addCourse(CourseDTO courseDTO) {
        coursesRepository.save(course(courseDTO));
    }

    private Course course(CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle((courseDTO.getTitle()));
        course.setDuration(courseDTO.getDuration());
        course.setDescription(courseDTO.getDescription());
        return course;
    }

    private CourseDTO courseDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setTitle((course.getTitle()));
        courseDTO.setDuration(course.getDuration());
        courseDTO.setDescription(course.getDescription());
        return courseDTO;
    }

    List<CourseDTO> findAll() {
        List<Course> all = coursesRepository.findAll();
        return all.stream()
                .map(this::courseDTO)
                .collect(Collectors.toList());
    }

    List<CourseDTO> findAllBySubcategory(Long subcategoryId) {
        Optional<Subcategory> subcategory = subcategoryRepository.findById(subcategoryId);
        return subcategory.map(value -> coursesRepository.findAllBySubcategory(value)
                .stream()
                .map(this::courseDTO)
                .collect(Collectors.toList())).orElseGet(ArrayList::new);
    }

}