package com.example.demo.training;

import com.example.demo.model.Category;
import com.example.demo.training.CategoryRepository;
import com.example.demo.model.Course;
import com.example.demo.training.CoursesRepository;
import com.example.demo.model.Subcategory;
import com.example.demo.training.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Profile("prod")
@Transactional
public class InitializeDatabase implements CommandLineRunner {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SubcategoryRepository subcategoryRepository;
    @Autowired
    CoursesRepository coursesRepository;

    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category("IT");
        Category category2 = new Category("SALES");
        Category category3 = new Category("MARKETING");
        Category category4 = new Category("OTHER");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);

        Subcategory subcategory11 = new Subcategory("Java", category1);
        Subcategory subcategory12 = new Subcategory("JS", category1);
        Subcategory subcategory13 = new Subcategory("C#", category1);
        Subcategory subcategory14 = new Subcategory("DevOps", category1);

        Subcategory subcategory21 = new Subcategory("Sprzedaż bezpośrednia", category2);
        Subcategory subcategory22 = new Subcategory("Techniki sprzedażowe", category2);
        Subcategory subcategory23 = new Subcategory("Motywacja zespołu", category2);

        Subcategory subcategory31 = new Subcategory("Social Media", category3);
        Subcategory subcategory32 = new Subcategory("Marketing szeptany", category3);

        Subcategory subcategory41 = new Subcategory("Jak zostać Weterynarzem", category4);
        Subcategory subcategory42 = new Subcategory("Jak nalewać Guinessa", category4);

        subcategoryRepository.save(subcategory11);
        subcategoryRepository.save(subcategory12);
        subcategoryRepository.save(subcategory13);
        subcategoryRepository.save(subcategory14);
        subcategoryRepository.save(subcategory21);
        subcategoryRepository.save(subcategory22);
        subcategoryRepository.save(subcategory23);
        subcategoryRepository.save(subcategory31);
        subcategoryRepository.save(subcategory32);
        subcategoryRepository.save(subcategory41);
        subcategoryRepository.save(subcategory42);

        Course course111 = new Course("Podstawowy", 10, subcategory11);
        Course course112 = new Course("Sredniozaawansowany", 20, subcategory11);
        Course course113 = new Course("Zaawansowany", 30, subcategory11);

        Course course121 = new Course("Podstawowy", 10, subcategory12);
        Course course122 = new Course("Sredniozaawansowany", 20, subcategory12);
        Course course123 = new Course("Zaawansowany", 30, subcategory12);

        Course course131 = new Course("Podstawowy", 10, subcategory13);
        Course course132 = new Course("Sredniozaawansowany", 20, subcategory13);
        Course course133 = new Course("Zaawansowany", 30, subcategory13);

        Course course141 = new Course("Podstawowy", 10, subcategory14);
        Course course142 = new Course("Sredniozaawansowany", 20, subcategory14);
        Course course143 = new Course("Zaawansowany", 30, subcategory14);

        coursesRepository.save(course111);
        coursesRepository.save(course112);
        coursesRepository.save(course113);
        coursesRepository.save(course121);
        coursesRepository.save(course122);
        coursesRepository.save(course123);
        coursesRepository.save(course131);
        coursesRepository.save(course132);
        coursesRepository.save(course133);
        coursesRepository.save(course141);
        coursesRepository.save(course142);
        coursesRepository.save(course143);

    }
}
