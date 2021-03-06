package com.example.demo.training;

class CourseDTO {

    private Long id;
    private String title;
    private int duration;
    private String description;

    CourseDTO(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    CourseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}