package com.example.demo.training;

import com.example.demo.model.Course;

import java.util.Optional;

public interface TrainingFacade {

    Optional<Course> findCourseById(Long id);
}
