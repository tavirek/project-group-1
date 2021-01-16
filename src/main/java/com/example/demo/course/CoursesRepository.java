package com.example.demo.course;

import com.example.demo.subcategory.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Course, Long> {

    @Query("select c from Course c where c.subcategory = :subcategory")
    public List<Course> findAllBySubcategory(Subcategory subcategory);

}