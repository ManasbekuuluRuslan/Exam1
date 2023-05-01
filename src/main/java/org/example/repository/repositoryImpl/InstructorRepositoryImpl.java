package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.example.config.HibernateConfig;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.repository.InstructorRepository;

import java.sql.SQLException;
import java.util.ArrayList;
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
        entityManager.getTransaction().begin();
       Query query = entityManager.createQuery("select i from  Instructor i");
        List<Instructor> instructors = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructors;
    }

    @Override
    public Instructor getInstructorById(Long id) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor;
    }

    @Override
    public void deleteInstructorById(Long id) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(instructor.getInstructorName() + " is deleted!");
    }

    @Override
    public String assignInstructorToCourse(Long instructorId, Long courseId) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        Course course = entityManager.find(Course.class, courseId);
        instructor.getCourses().add(course);
        entityManager.getTransaction().commit();entityManager.close();
        return instructor.getInstructorName()+ " assigned to "+course.getCourseName() + " course!";
    }

    @Override
    public List<Instructor> getInstructorsByCourseId(Long courseId) {
        List<Instructor> instructors = null;
            entityManager.getTransaction().begin();
            try {
                String sql = "select i from Instructor i join Course c on i.courses where i.id = :courseId";
            TypedQuery<Instructor> resultList = entityManager.createQuery(sql, Instructor.class);
                   resultList.setParameter("courseId", courseId);
            instructors = resultList.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return instructors;
    }

    @Override
    public Instructor getInstructorByName(String name) {
        entityManager.getTransaction().begin();
        String sql = "select i from Instructor i where i.instructorName = :name";
        TypedQuery <Instructor> instructor = entityManager.createQuery(sql, Instructor.class);
        instructor.setParameter("name",name);
        List<Instructor> instructors = instructor.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        if(instructors.size() > 0){
            return instructors.get(0);
        }else{
            return null;
        }

    }
}
