package com.example.hw_1;

public class Category {
    private int image;
    private String name;

    public Category(int imageResource, String name) {
        this.image = imageResource;
        this.name = name;
    }

    public int getImageResource() {
        return image;
    }

    public String getName() {
        return name;
    }
}

