package com.example.demo.sendMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service("EmailService")
public class DefaultMailSender implements MailSender {

    private static final String NOREPLY_ADDRESS = "przykladowymail03@gmail.com";

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String content) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(NOREPLY_ADDRESS);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(content);
            javaMailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }

//        @Override
//        public void sendSimpleMessageUsingTemplate(String to,
//                String subject,
//                String ...templateModel) {
//            String text = String.format(template.getText(), templateModel);
//            sendSimpleMessage(to, subject, text);
//        }

    }





//    public void sendEmail(String to, String title, String content) {
//        MimeMessage mail = javaMailSender.createMimeMessage();
//        try {
//            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
//            helper.setTo(to);
//            helper.setReplyTo("przykladowymail03@gmail.com");
//            helper.setFrom("przykladowymail03@gmail.com");
//            helper.setSubject(title);
//            helper.setText(content, true);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        javaMailSender.send(mail);
//    }
}
