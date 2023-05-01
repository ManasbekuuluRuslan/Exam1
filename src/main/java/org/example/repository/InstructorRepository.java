package org.example.repository;

import org.example.entity.Instructor;

import java.util.List;

public interface InstructorRepository {
    String saveInstructor(Instructor instructor);
    List<Instructor> getAllInstructors();
    Instructor getInstructorById(Long id);
    void deleteInstructorById(Long id);
    String assignInstructorToCourse(Long instructorId,Long courseId);
    List<Instructor> getInstructorsByCourseId(Long courseId);
    Instructor getInstructorByName(String name);

}
