package com.example.demo.course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Course, Long> {
}