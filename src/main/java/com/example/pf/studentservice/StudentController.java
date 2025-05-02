package com.example.pf.studentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int credits) {

        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setCredits(credits);

        Student registeredStudent = studentService.registerStudent(student);
        return ResponseEntity.ok(registeredStudent);
    }

    @GetMapping("/eligibility/{email}")
    public ResponseEntity<Boolean> checkEligibility(@PathVariable String email) {
        boolean eligibility = studentService.isEligibleForCourse(email);
        return ResponseEntity.ok(eligibility);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
