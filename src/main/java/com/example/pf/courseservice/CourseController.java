package com.example.pf.courseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

   
    @GetMapping("/available")
    public ResponseEntity<List<Course>> getAvailableCourses() {
        List<Course> courses = courseService.getAvailableCourses();
        return ResponseEntity.ok(courses);  
    }

    
    @PostMapping("/add")
public ResponseEntity<Course> addCourse(@RequestBody Course course) {
    Course createdCourse = courseService.addCourse(course);
    return ResponseEntity.ok(createdCourse);  
}

}
