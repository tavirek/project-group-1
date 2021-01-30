package com.example.demo.sendMail;

public class TestMailSender implements MailSender {

    private String to;
    private String subject;
    private String content;

    @Override
    public void sendEmail(String to, String subject, String content) {
    this.to = to;
    this.subject = subject;
    this.content = content;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }
}
