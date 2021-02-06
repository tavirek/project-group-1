package com.example.demo.sendMail;

import com.example.demo.model.Category;
import com.example.demo.model.Course;
import com.example.demo.training.CoursesInMemoryRepository;
import com.example.demo.training.CoursesRepository;
import com.example.demo.model.Subcategory;
import com.example.demo.training.TrainingFacade;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MailSenderServiceTest {

    private CoursesRepository coursesRepository = new CoursesInMemoryRepository();
    private TestMailSender mailSender = new TestMailSender();
    private TrainingFacade trainingFacade = new InMemoryTrainingFacade(coursesRepository);
    private MailSenderService mailSenderService = new MailSenderService(trainingFacade, mailSender) {};

    @Test
    public void shouldMailWasSendWithCorrectData() {
        //given
        String adress = "mail@mail.com";
        List<Long> ids = new ArrayList<>();
        ids.add((long) 0);
        ids.add((long) 1);

        Category it = new Category("IT");
        Subcategory java = new Subcategory("Java", it);
        Course course1 = new Course("podstawowy",10,java);
        Course course2 = new Course("średni",10,java);
        Course course3 = new Course("zaawansowany",10,java);
        coursesRepository.save(course1);
        coursesRepository.save(course2);
        coursesRepository.save(course3);
        //when
        mailSenderService.sendOffer(adress, ids);

        //then
        assertEquals(mailSender.getTo(), adress);
        assertEquals(mailSender.getSubject(), "Oferta");
        assertTrue(mailSender.getContent().contains("podstawowy"));
        assertTrue(mailSender.getContent().contains("średni"));
        assertFalse(mailSender.getContent().contains("zaawansowany"));


    }

}