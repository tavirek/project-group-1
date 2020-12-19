package com.example.demo;

import com.example.demo.repository.CoursesRepository;
import com.example.demo.training.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProjectGroup1ApplicationTests {

	@Autowired
	CoursesRepository coursesRepository;
	@Test
	void contextLoads() {
		Course course1 = new Course("course1",5);
		Course course2 = new Course("course2",6);
		Course course3 = new Course("course3",7);

		Course savedCourse1 = coursesRepository.save(course1);
		Course savedCourse2 = coursesRepository.save(course2);
		Course savedCourse3 = coursesRepository.save(course3);

		List<Course> allCourses = coursesRepository.findAll();
		System.out.println("Wszystkie kursy: "+ allCourses);
		assertThat(allCourses).isNotEmpty();
	}

}
