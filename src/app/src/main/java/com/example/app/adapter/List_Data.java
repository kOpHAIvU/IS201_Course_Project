package com.example.app.adapter;

public class List_Data {
    String name;
    int img;

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public List_Data(String name, int img) {
        this.name = name;
        this.img = img;
    }
}
