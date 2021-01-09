package com.example.demo.subcategory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameSubcategory;
    private String description;


    public Subcategory(String nameSubcategory) {
        this.nameSubcategory = nameSubcategory;
    }

    public Subcategory() {
    }

    public String getNameSubcategory() {
        return nameSubcategory;
    }

    public void setNameSubcategory(String nameSubcategory) {
        this.nameSubcategory = nameSubcategory;
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
                "nameSubcategory='" + nameSubcategory + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
