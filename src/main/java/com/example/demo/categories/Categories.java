package com.example.demo.categories;

import javax.persistence.Entity;

@Entity
public class Categories {

    private String nameCategories;
    private String description;

    public Categories(String nameCategories) {
        this.nameCategories = nameCategories;
    }

    public Categories() {
    }

    public String getNameCategories() {
        return nameCategories;
    }

    public void setNameCategories(String nameCategories) {
        this.nameCategories = nameCategories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "nameCategories='" + nameCategories + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

