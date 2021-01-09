package com.example.demo.subcategory;

public class SubcategoryDTO {
    private Long id;
    private String name;
    private String description;

    public SubcategoryDTO(String name) {
        this.name = name;
    }

    public SubcategoryDTO() {
    }

    public String getNameSubcategory() {
        return name;
    }

    public void setNameSubcategory(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
