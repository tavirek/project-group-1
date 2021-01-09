package com.example.demo.categories;

public class CategoriesDTO {

    private String nameCategories;
    private String description;

    public CategoriesDTO(String nameCategories) {
        this.nameCategories = nameCategories;
    }

    public CategoriesDTO() {
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
        return "CategoriesDTO{" +
                "nameCategories='" + nameCategories + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
