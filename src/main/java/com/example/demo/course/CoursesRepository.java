package com.example.demo.course;

import com.example.demo.subcategory.Subcategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface CoursesRepository extends Repository<Course, Long> {

    @Query("select c from Course c where c.subcategory = :subcategory")
    public List<Course> findAllBySubcategory(Subcategory subcategory);

    Course save(Course course);

    List<Course> findAll();

    Optional<Course> findById(long id);
}