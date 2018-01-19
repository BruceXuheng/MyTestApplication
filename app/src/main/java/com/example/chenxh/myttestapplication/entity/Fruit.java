package com.example.chenxh.myttestapplication.entity;

public class Fruit {

    private String name;
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Fruit(String name, String date) {
        this.name = name;
        this.date = date;
    }
}