package com.example.demo.course;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CoursesRepository coursesRepository;

    public CourseService(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public void addCourse(CourseDTO courseDTO) {
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
        courseDTO.setTitle((course.getTitle()));
        courseDTO.setDuration(course.getDuration());
        courseDTO.setDescription(course.getDescription());
        return courseDTO;
    }

    public List<CourseDTO> findAll() {
        List<Course> all = coursesRepository.findAll();
        return all.stream()
                .map(this::courseDTO)
                .collect(Collectors.toList());
    }
}