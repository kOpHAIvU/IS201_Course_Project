package com.example.app.adapter;

public class List_Notifications {
    String title, poster, description;
    public String getTitle() {
        return title;
    }
    public String getPoster() {
        return poster;
    }
    public String getDescription() {
        return description;
    }
    public List_Notifications(String title, String poster, String description) {
        this.title = title;
        this.poster = poster;
        this.description = description;
    }
}
