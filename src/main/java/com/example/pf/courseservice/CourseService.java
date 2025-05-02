package com.example.pf.courseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    
    public List<Course> getAvailableCourses() {
        return courseRepository.findByAvailableSeatsGreaterThan(0);
    }

   
    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);  
    }

    
    public Course addCourse(Course course) {
        return courseRepository.save(course);  
    }
}
