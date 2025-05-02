package com.example.pf.registrationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

 
    @PostMapping("/register")
    public ResponseEntity<String> registerForCourse(@RequestParam String studentEmail,
                                                    @RequestParam Long courseId) {
        
        if (studentEmail == null || studentEmail.isEmpty()) {
            return ResponseEntity.badRequest().body("Student email is required");
        }
        if (courseId == null || courseId <= 0) {
            return ResponseEntity.badRequest().body("Invalid course ID");
        }

        
        String responseMessage = registrationService.registerForCourse(studentEmail, courseId);

       
        if (responseMessage.contains("Successfully")) {
            return ResponseEntity.ok(responseMessage);
        } else {
            return ResponseEntity.badRequest().body(responseMessage);
        }
    }
}
