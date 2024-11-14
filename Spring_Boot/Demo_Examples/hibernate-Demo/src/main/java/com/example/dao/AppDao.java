package com.example.dao;

import com.example.entity.Instructor;

public interface AppDao {
    void save(Instructor instructor);
    Instructor findByID(int id);
    void deleteInstructorById(int id);
}
