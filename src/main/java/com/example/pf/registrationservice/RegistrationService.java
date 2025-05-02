package com.example.pf.registrationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public String registerForCourse(String studentEmail, Long courseId) {
        
        if (studentEmail.equals("invalid@example.com")) {
            return "Student with email " + studentEmail + " is not eligible for registration";
        }

        // Create a new Registration object
        Registration registration = new Registration();
        registration.setStudentEmail(studentEmail);
        registration.setCourseId(courseId);

        // Save registration to the database
        registrationRepository.save(registration);

        return "Successfully registered student with email " + studentEmail + " for course with ID " + courseId;
    }
}
