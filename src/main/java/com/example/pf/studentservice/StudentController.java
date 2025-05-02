package com.example.pf.studentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
