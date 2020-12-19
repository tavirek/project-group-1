package com.example.demo.repository;

import com.example.demo.training.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Course, Long> {

}
