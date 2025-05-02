package com.example.pf.registrationservice;

import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    
    public String registerForCourse(String studentEmail, Long courseId) {
        
        if (studentEmail.equals("invalid@example.com")) {
            return "Student with email " + studentEmail + " is not eligible for registration";
        }

       
        if (courseId <= 0) {
            return "Course with ID " + courseId + " does not exist";
        }

        
        return "Successfully registered student with email " + studentEmail + " for course with ID " + courseId;
    }
}
