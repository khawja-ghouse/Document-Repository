package com.skg.patterns.structural.adapter;

public class SchoolStudent {

    private String name;
    private String surName;
    private String email;

    public SchoolStudent(String name, String surName, String email) {
        this.name = name;
        this.surName = surName;
        this.email = email;
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

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surName;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return "SchoolStudent{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
