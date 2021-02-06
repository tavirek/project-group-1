package com.example.demo.sendMail;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MailSenderController {

    private MailSenderService mailSenderService;

    public MailSenderController(MailSenderService mailSenderService){
        this.mailSenderService = mailSenderService;
    }

    @PostMapping(path = "/email")
    void sendMail(@RequestBody MailDTO mailDTO){
        mailSenderService.sendOffer(mailDTO.getRecipient(), mailDTO.getCourses());
    }

















//
//    List<Long> idList;
//    String to;
//
//        public MailSenderController(List<Long> idList, String to){
//            this.idList = idList;
//            this.to = to;
//        }





//    obiekt w którego sklad wchodzi lista id i adres odbiorcy
    // metoda która przyjmie ten obiekt postem i wywola serwis do wysyłania maili

}
