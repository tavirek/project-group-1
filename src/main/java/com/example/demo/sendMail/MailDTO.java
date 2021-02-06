package com.example.demo.sendMail;

import java.util.List;

public class MailDTO {

    String recipient;
    List<Long> courses;

    public MailDTO() {
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public List<Long> getCourses() {
        return courses;
    }

    public void setCourses(List<Long> courses) {
        this.courses = courses;
    }
}
