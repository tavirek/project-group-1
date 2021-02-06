package com.example.demo.model;

import com.example.demo.model.Category;

import javax.persistence.*;

@Entity
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    private String name;
    private String description;

    public Subcategory(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Subcategory() {
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
