package org.example.service;

import org.example.entity.Instructor;

import java.util.List;

public interface InstructorService {
    String saveInstructor(Instructor instructor);
    List<Instructor> getAllInstructors();
}
