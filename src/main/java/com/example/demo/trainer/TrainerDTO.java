package com.example.demo.trainer;

public class TrainerDTO {
    private Long id;
    private String name;
    private String surname;
    private Long pesel;

    public TrainerDTO(String name, String surname, Long pesel) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }

    public TrainerDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
