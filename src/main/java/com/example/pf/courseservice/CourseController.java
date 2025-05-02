package com.example.pf.courseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // 1. Get all courses
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    // 2. Get course by ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = courseService.getCourseById(id);
        return course.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    // 3. Get only available courses (seats > 0)
    @GetMapping("/available")
    public ResponseEntity<List<Course>> getAvailableCourses() {
        List<Course> courses = courseService.getAvailableCourses();
        return ResponseEntity.ok(courses);
    }

    // 4. Add new course
    @PostMapping("/add")
    public ResponseEntity<Course> addCourse(@RequestParam String name,
                                            @RequestParam int credits,
                                            @RequestParam int availableSeats) {
        Course course = new Course();
        course.setName(name);
        course.setCredits(credits);
        course.setAvailableSeats(availableSeats);

        Course createdCourse = courseService.addCourse(course);
        return ResponseEntity.ok(createdCourse);
    }
}
