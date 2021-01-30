package com.example.demo.sendMail;

import com.example.demo.course.CoursesRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MailSenderService {

    private final CoursesRepository coursesRepository;
    private final MailSender mailSender;

    public MailSenderService(CoursesRepository coursesRepository, MailSender mailSender) {
        this.coursesRepository = coursesRepository;
        this.mailSender = mailSender;
    }

    public void sendOffer(String adress, List<Long> ids) {
        String mailContent = ids.stream().map(id -> coursesRepository.findById(id))
                .filter(item -> item.isPresent())
                .map(item -> item.get())
                .map(item -> item.getTitle())
                .collect(Collectors.joining("\n"));
        mailSender.sendEmail(adress, "Oferta", mailContent);

    }
}
