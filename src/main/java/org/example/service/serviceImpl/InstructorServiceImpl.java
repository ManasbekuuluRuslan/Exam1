package org.example.service.serviceImpl;

import org.example.entity.Instructor;
import org.example.repository.InstructorRepository;
import org.example.repository.repositoryImpl.InstructorRepositoryImpl;
import org.example.service.InstructorService;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {
InstructorRepository instructorRepository = new InstructorRepositoryImpl();
    @Override
    public String saveInstructor(Instructor instructor) {
        return instructorRepository.saveInstructor(instructor);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.getAllInstructors();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public void deleteInstructorById(Long id) {
instructorRepository.deleteInstructorById(id);
    }

    @Override
    public String assignInstructorToCourse(Long instructorId, Long courseId) {
        return instructorRepository.assignInstructorToCourse(instructorId, courseId);
    }

    @Override
    public List<Instructor> getInstructorsByCourseId(Long courseId) {
        return instructorRepository.getInstructorsByCourseId(courseId);
    }

    @Override
    public Instructor getInstructorByName(String name) {
        return instructorRepository.getInstructorByName(name);
    }
}
