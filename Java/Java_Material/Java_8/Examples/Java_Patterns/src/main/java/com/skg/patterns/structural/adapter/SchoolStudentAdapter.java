package com.skg.patterns.structural.adapter;

public class SchoolStudentAdapter implements Student{

    SchoolStudent schoolStudent;

    public SchoolStudentAdapter(SchoolStudent schoolStudent){
        this.schoolStudent = schoolStudent;
    }


    @Override
    public String getName() {
        return this.schoolStudent.getName();
    }

    @Override
    public String getSurname() {
        return this.schoolStudent.getSurname();
    }

    @Override
    public String getEmail() {
        return this.schoolStudent.getEmail();
    }

    @Override
    public String toString() {
        return "SchoolStudentAdapter{" +
                "schoolStudent=" + schoolStudent +
                '}';
    }
}
