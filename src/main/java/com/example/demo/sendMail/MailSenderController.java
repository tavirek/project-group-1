package com.example.demo.sendMail;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sendmail")
public class MailSenderController {

//    obiekt w którego sklad wchodzi lista id i adres odbiorcy
    // metoda która przyjmie ten obiekt postem i wywola serwis do wysyłania maili

}
