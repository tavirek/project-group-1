package com.example.demo.training;

import com.example.demo.model.Course;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DefaultTrainingFacade implements TrainingFacade {

    private final CoursesRepository coursesRepository;

    public DefaultTrainingFacade(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public Optional<Course> findCourseById(Long id) {
    return coursesRepository.findById(id);
    }
}
