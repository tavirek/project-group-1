package com.example.demo.course;

import com.example.demo.subcategory.Subcategory;
import com.example.demo.subcategory.SubcategoryRepository;
import com.example.demo.subcategory.SubcategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class CourseTest {

    @Autowired
    CourseService courseService;

    @Autowired
    SubcategoryService subcategoryService;

    @Autowired
    CoursesRepository coursesRepository;

    @Autowired
    SubcategoryRepository subcategoryRepository;

    @Test
    public void shouldAddSubcategoryToCourse() {
        //given
        Subcategory subcategory = new Subcategory("IT");
        Course course = new Course("java",7,subcategory);
        Course course1 = new Course("js",12,subcategory);
        Subcategory subcategory1 = new Subcategory("Sales");
        Course course2 = new Course("sprzedaz bulek",7,subcategory1);
        Course course3 = new Course("sprzedaz ciastek",12,subcategory1);

        //when
        init(subcategory, course, course1, subcategory1, course2, course3);

        //then
        Optional<Subcategory> it = subcategoryRepository.findOneByName("IT");
        List<CourseDTO> itCourses = courseService.findAllBySubcategory(it.get().getId());
        assertEquals(2,itCourses.size());

    }

    private void init(Subcategory subcategory, Course course, Course course1, Subcategory subcategory1, Course course2, Course course3) {
        subcategoryRepository.save(subcategory);
        coursesRepository.save(course);
        coursesRepository.save(course1);
        subcategoryRepository.save(subcategory1);
        coursesRepository.save(course2);
        coursesRepository.save(course3);
    }
}