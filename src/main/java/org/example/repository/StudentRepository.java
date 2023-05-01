package org.example.repository;

import org.example.jdbc.Student;

import java.util.List;

public interface StudentRepository {
    String createTable();
    List<Student> getAllStudents();
}
