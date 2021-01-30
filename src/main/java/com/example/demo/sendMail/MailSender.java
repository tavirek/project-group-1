package com.example.demo.sendMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MailSender {

        @Autowired
        private JavaMailSender javaMailSender;

        @Override
        public void sendEmail (String to, String title, String content){
            MimeMessage mail = javaMailSender.createMimeMessage();
            try {
                MimeMessageHelper helper = new MimeMessageHelper(mail, true);
                helper.setTo(to);
                helper.setReplyTo("newsletter@codecouple.pl");
                helper.setFrom("newsletter@codecouple.pl");
                helper.setSubject(title);
                helper.setText(content, true);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            javaMailSender.send(mail);


        }

}
