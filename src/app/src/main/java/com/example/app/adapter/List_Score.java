package com.example.app.adapter;

public class List_Score {
    String courseID, speak, write, listen, read;

    public String getCourseID() {
        return courseID;
    }

    public String getSpeak() {
        return speak;
    }

    public String getWrite() {
        return write;
    }

    public String getListen() {
        return listen;
    }

    public String getRead() {
        return read;
    }

    public List_Score(String courseID, String speak, String write, String listen, String read) {
        this.courseID = courseID;
        this.speak = speak;
        this.write = write;
        this.listen = listen;
        this.read = read;
    }
}
