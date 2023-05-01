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
}
