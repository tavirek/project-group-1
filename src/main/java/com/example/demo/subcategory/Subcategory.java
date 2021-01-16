package com.example.demo.subcategory;

import com.example.demo.course.Course;

import javax.persistence.*;

@Entity
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    public Subcategory(String name) {
        this.name = name;
    }

    public Subcategory() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Subcategory{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
