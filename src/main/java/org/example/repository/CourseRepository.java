package org.example.repository;

import org.example.entity.Course;
import org.example.entity.Instructor;

import java.util.List;

public interface CourseRepository {
    String saveCourse(Course course);
    String updateCourse(Long id,Course course);
    List<Course> getAllCoursesByInstructorID(Long id);
    Course getCourseById(Long id);
    void deleteCourseById(Long id);
    List<Course> getAllCourses();

}
