package com.example.demo.subcategories;

public class SubcategoriesDTO {
    private Long id;
    private String name;
    private String description;

    public SubcategoriesDTO(String name) {
        this.name = name;
    }

    public SubcategoriesDTO() {
    }

    public String getNameSubcategories() {
        return name;
    }

    public void setNameSubcategories(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Subcourses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
