package com.example.demo.category;

public class CategoryDTO {

    private String nameCategory;
    private String description;

    public CategoryDTO(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public CategoryDTO() {
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setName(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "nameCategory='" + nameCategory + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
