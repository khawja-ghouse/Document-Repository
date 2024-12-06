package com.skg.patterns.structural.adapter;

public class CollageStudent implements  Student{

    private String name;
    private String surName;
    private String email;

    public CollageStudent(String email, String surName, String name) {
        this.email = email;
        this.surName = surName;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSurname() {
        return this.surName;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return "CollageStudent{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
