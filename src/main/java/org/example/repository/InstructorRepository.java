package org.example.repository;

import org.example.entity.Instructor;

import java.util.List;

public interface InstructorRepository {
    String saveInstructor(Instructor instructor);
    List<Instructor> getAllInstructors();

}
