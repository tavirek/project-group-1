package com.example.demo.training;
import com.example.demo.model.Course;
import com.example.demo.model.Subcategory;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class CoursesInMemoryRepository implements CoursesRepository {

    Map<Long, Course> courses = new ConcurrentHashMap<>();

    @Override
    public List<Course> findAllBySubcategory(Subcategory subcategory) {
        return null;
    }

    @Override
    public Course save(Course course) {
        long key = courses.size();
        course.setId(key);
        courses.put(key,course);
        return course;
    }

    @Override
    public List<Course> findAll() {
        return courses.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Course> findById(long id) {
        return courses.values().stream().filter(course -> course.getId().equals(id)).findFirst();
    }

    @Override
    public long count() {
        return courses.values().size();
    }


}


