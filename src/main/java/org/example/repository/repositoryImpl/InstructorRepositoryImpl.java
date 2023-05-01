package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.entity.Instructor;
import org.example.repository.InstructorRepository;

import java.util.List;

public class InstructorRepositoryImpl implements InstructorRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public String saveInstructor(Instructor instructor) {
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor.getInstructorName() + " is saved!";
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return null;
    }
}
