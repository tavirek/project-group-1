package com.example.demo;

import com.example.demo.category.Category;
import com.example.demo.category.CategoryRepository;
import com.example.demo.course.Course;
import com.example.demo.course.CoursesRepository;
import com.example.demo.subcategory.Subcategory;
import com.example.demo.subcategory.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class ProjectGroup1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectGroup1Application.class, args);
	}





}