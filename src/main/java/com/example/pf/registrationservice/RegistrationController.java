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
    public ResponseEntity<String> registerForCourse(@RequestBody RegistrationRequest registrationRequest) {
        
        if (registrationRequest.getStudentEmail() == null || registrationRequest.getStudentEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("Student email is required");
        }
        if (registrationRequest.getCourseId() == null || registrationRequest.getCourseId() <= 0) {
            return ResponseEntity.badRequest().body("Invalid course ID");
        }

        String responseMessage = registrationService.registerForCourse(registrationRequest.getStudentEmail(), registrationRequest.getCourseId());

        if (responseMessage.contains("Successfully")) {
            return ResponseEntity.ok(responseMessage);
        } else {
            return ResponseEntity.badRequest().body(responseMessage);
        }
    }
}
