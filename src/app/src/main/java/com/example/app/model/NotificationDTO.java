package com.example.app.model;

public class NotificationDTO {
    private String title;
    private String poster;
    private String description;
    public String getTitle() {
        return title;
    }
    public String getPoster() {
        return poster;
    }
    public String getDescription() {
        return description;
    }
    public NotificationDTO(String title, String poster, String description) {
        this.title = title;
        this.poster = poster;
        this.description = description;
    }

    @Override
    public String toString() {
        return "List_Notifications{" +
                "title='" + title + '\'' +
                ", poster='" + poster + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
