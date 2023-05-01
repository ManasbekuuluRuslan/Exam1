package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.example.config.Config;
import org.example.config.HibernateConfig;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.repository.CourseRepository;
import org.hibernate.Transaction;
import java.sql.PreparedStatement;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public String saveCourse(Course course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course.getCourseName() + " is saved!";
    }

    @Override
    public String updateCourse(Long id, Course course) {
         entityManager.getTransaction().begin();
        Course course1 = entityManager.find(Course.class, id);
        if(course1!= null){
            course1.setCourseName(course.getCourseName());
            course1.setDateOfStart(course1.getDateOfStart());
        }
        entityManager.merge(course1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course.getCourseName() +" is updated! ";
   }

    @Override
    public List<Course> getAllCoursesByInstructorID(Long id) {
        entityManager.getTransaction().begin();
        List<Course> courses = null;
        try {
            String sql = "select c from Course c join Instructor i on i.courses where c.id = :id";
            TypedQuery<Course> query = entityManager.createQuery(sql, Course.class);
            query.setParameter("id", id);
            courses = query.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }            return courses;
    }

    @Override
    public Course getCourseById(Long id) {
         entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }

    @Override
    public void deleteCourseById(Long id) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Course> getAllCourses() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select c from Course c");
        List<Course> courses = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courses;
    }
}
