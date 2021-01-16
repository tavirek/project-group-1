package com.example.demo.course;

import com.example.demo.category.Category;
import com.example.demo.category.CategoryRepository;
import com.example.demo.category.CategoryService;
import com.example.demo.subcategory.Subcategory;
import com.example.demo.subcategory.SubcategoryDTO;
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

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void shouldAddSubcategoryToCourseAndCategoryToSubcategory() {
        //given
        Category category = new Category("IT");
        Subcategory subcategory = new Subcategory("Java", category);
        Course course = new Course("java", 7, subcategory);
        Course course1 = new Course("java2", 12, subcategory);
        Category category1 = new Category("Sales");
        Subcategory subcategory1 = new Subcategory("Sales", category1);
        Course course2 = new Course("sprzedaz bulek", 7, subcategory1);
        Course course3 = new Course("sprzedaz ciastek", 12, subcategory1);

        //when
        init(category, subcategory, course, course1, category1, subcategory1, course2, course3);

        //then
        Optional<Subcategory> java = subcategoryRepository.findOneByName("Java");
        List<CourseDTO> javaCourses = courseService.findAllBySubcategory(java.get().getId());
        assertEquals(2, javaCourses.size());
        Optional<Category> it = categoryRepository.findOneByName("IT");
        List<SubcategoryDTO> itSubcategories = subcategoryService.findAllByCategory(it.get().getId());
        assertEquals(1, itSubcategories.size());
    }

    private void init(Category category, Subcategory subcategory, Course course, Course course1, Category category1, Subcategory subcategory1, Course course2, Course course3) {
        categoryRepository.save(category);
        subcategoryRepository.save(subcategory);
        coursesRepository.save(course);
        coursesRepository.save(course1);
        categoryRepository.save(category1);
        subcategoryRepository.save(subcategory1);
        coursesRepository.save(course2);
        coursesRepository.save(course3);
    }
}