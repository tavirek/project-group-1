package com.example.demo.services;

import com.example.demo.course.Course;
import com.example.demo.course.CourseDTO;
import com.example.demo.repository.CoursesRepository;
import com.example.demo.repository.TrainerRepository;
import com.example.demo.trainer.Trainer;
import com.example.demo.trainer.TrainerDTO;
import org.springframework.context.annotation.Configuration;

@Configuration
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
}


