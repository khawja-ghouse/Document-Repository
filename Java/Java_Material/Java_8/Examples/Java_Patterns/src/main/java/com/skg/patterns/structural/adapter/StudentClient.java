package com.skg.patterns.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class StudentClient {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        CollageStudent collageStudent = new CollageStudent("ghousekhawja@gmail.com","Ghouse","Khwaja");
        studentList.add(collageStudent);

        // Lets try to add school student also to the studentList
        SchoolStudent schoolStudent = new SchoolStudent("Nadeem","Syed","syedNadeem@gmail.com");
        // studentList.add(schoolStudent); // can't add this.

        // We cannot do this because SchoolStudent is not implementing Student interface

        // For this SchoolStudent to be added we need to create a Adapter class so that
        // schoolStudent gets Adapted to Student interface.

        studentList.add(new SchoolStudentAdapter(schoolStudent));

        studentList.forEach(System.out::println);
    }

}
