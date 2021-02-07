package com.example.demo.sendMail;

import com.example.demo.training.DefaultTrainingFacade;
import com.example.demo.training.TrainingFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MailSenderService {

    private final TrainingFacade trainingFacade;
    private final MailSender mailSender;

    public MailSenderService(TrainingFacade trainingFacade, MailSender mailSender) {
        this.trainingFacade = trainingFacade;
        this.mailSender = mailSender;
    }

    public void sendOffer(String adress, List<Long> ids) {
        String mailContent = ids.stream().map(id -> trainingFacade.findCourseById(id))
                .filter(item -> item.isPresent())
                .map(item -> item.get())
                .map(item -> item.getTitle())
                .collect(Collectors.joining("\n"));
        mailSender.sendEmail(adress, "Oferta", "Cześć!\n" +
                "\n" +
                "Dziękujemy za zainteresowanie ofertą naszych kursów. \n" +
                "Poniższej szczegóły kursów, które Cię interesują:\n" +
                "\n" +
                mailContent +
                "\n" +
                "\n" +
                "Pozdrawiamy, \n" +
                "Zespół INQOO");

    }
}
