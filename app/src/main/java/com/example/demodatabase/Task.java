package com.example.demodatabase;

public class Task {
    private int id;
    private String description;
    private String date;

    public Task(int id, String description, String date) {
        this.id = id;
        this.description = description;
        this.date = date;
    }

    public int getID() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String toString() {
        return id + "\n" + description + "\n" + date;
    }


}