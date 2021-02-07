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

        Course course111 = new Course("Java Podstawowy", 10, subcategory11);
        Course course112 = new Course("Java Sredni", 20, subcategory11);
        Course course113 = new Course("Java Zaawansowany", 30, subcategory11);

        Course course121 = new Course("JS Podstawowy", 10, subcategory12);
        Course course122 = new Course("JS Sredni", 20, subcategory12);
        Course course123 = new Course("JS Zaawansowany", 30, subcategory12);

        Course course131 = new Course("C# Podstawowy", 10, subcategory13);
        Course course132 = new Course("C# Sredni", 20, subcategory13);
        Course course133 = new Course("C# Zaawansowany", 30, subcategory13);

        Course course141 = new Course("DevOps Podstawowy", 10, subcategory14);
        Course course142 = new Course("DevOps Sredni", 20, subcategory14);
        Course course143 = new Course("Devops Zaawansowany", 30, subcategory14);

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

        Course course211 = new Course(" Podstawowy", 10, subcategory21);
        Course course212 = new Course(" Sredni", 20, subcategory21);
        Course course213 = new Course(" Zaawansowany", 30, subcategory21);

        Course course311 = new Course(" Podstawowy", 10, subcategory31);
        Course course312 = new Course(" Sredni", 20, subcategory31);
        Course course313 = new Course(" Zaawansowany", 30, subcategory31);

        Course course411 = new Course(" Podstawowy", 10, subcategory41);
        Course course412 = new Course(" Sredni", 20, subcategory41);
        Course course413 = new Course(" Zaawansowany", 30, subcategory41);

        coursesRepository.save(course211);
        coursesRepository.save(course212);
        coursesRepository.save(course213);

        coursesRepository.save(course311);
        coursesRepository.save(course312);
        coursesRepository.save(course313);

        coursesRepository.save(course411);
        coursesRepository.save(course412);
        coursesRepository.save(course413);

        Course course221 = new Course(" Podstawowy", 10, subcategory22);
        Course course222 = new Course(" Sredni", 20, subcategory22);
        Course course223 = new Course(" Zaawansowany", 30, subcategory22);

        Course course231 = new Course(" Podstawowy", 10, subcategory23);
        Course course232 = new Course(" Sredni", 20, subcategory23);
        Course course233 = new Course(" Zaawansowany", 30, subcategory23);

        Course course321 = new Course(" Podstawowy", 10, subcategory32);
        Course course322 = new Course(" Sredni", 20, subcategory32);
        Course course323 = new Course(" Zaawansowany", 30, subcategory32);

        Course course421 = new Course(" Podstawowy", 10, subcategory42);
        Course course422 = new Course(" Sredni", 20, subcategory42);
        Course course423 = new Course(" Zaawansowany", 30, subcategory42);

        coursesRepository.save(course221);
        coursesRepository.save(course222);
        coursesRepository.save(course223);

        coursesRepository.save(course231);
        coursesRepository.save(course232);
        coursesRepository.save(course233);

        coursesRepository.save(course321);
        coursesRepository.save(course322);
        coursesRepository.save(course323);

        coursesRepository.save(course421);
        coursesRepository.save(course422);
        coursesRepository.save(course423);

    }
}
