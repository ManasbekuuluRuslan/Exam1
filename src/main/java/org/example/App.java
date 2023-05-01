package org.example;

import org.example.config.Config;
import org.example.config.HibernateConfig;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.repository.StudentRepository;
import org.example.service.CourseService;
import org.example.service.InstructorService;
import org.example.service.serviceImpl.CourseServiceImpl;
import org.example.service.serviceImpl.InstructorServiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
//        StudentRepository studentRepository = new StudentRepositoryImpl();
//        System.out.println(studentRepository.createTable());
        InstructorService instructorService = new InstructorServiceImpl();
        CourseService courseService = new CourseServiceImpl();
//        System.out.println(instructorService.saveInstructor(new Instructor("Aijamal", "aijamal@gmail.com", 50523232)));
//        System.out.println(courseService.saveCourse(new Course("Java-9", LocalDate.of(2023, 1, 3))));
//       System.out.println(courseService.getAllCoursesByInstructorID(1L));
//        courseService.deleteCourseById(1L);
//        System.out.println(courseService.getCourseById(2L));
//        System.out.println(courseService.getAllCourses());
//        System.out.println(courseService.updateCourse(2L, new Course(
//                "Java-9", LocalDate.of(2023, 1, 3))));
//        System.out.println(instructorService.getInstructorsByCourseId(1L));
//        System.out.println(instructorService.assignInstructorToCourse(2L, 3L));
//        System.out.println(instructorService.getInstructorByName("Datka"));
//        System.out.println(instructorService.getInstructorById(2L));
instructorService.deleteInstructorById(3L);
    }
}
