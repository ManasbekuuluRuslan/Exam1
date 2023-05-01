package org.example.service.serviceImpl;

import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.repository.CourseRepository;
import org.example.repository.repositoryImpl.CourseRepositoryImpl;
import org.example.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository = new CourseRepositoryImpl();
    @Override
    public String saveCourse(Course course) {
        return courseRepository.saveCourse(course);
    }

    @Override
    public String updateCourse(Long id, Course course) {
        return courseRepository.updateCourse(id, course);
    }

    @Override
    public List<Course> getAllCoursesByInstructorID(Long id) {
        return courseRepository.getAllCoursesByInstructorID(id);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteCourseById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }
}
