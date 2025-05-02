package com.example.pf.registrationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public String registerForCourse(String studentEmail, Long courseId) {
        if ("invalid@example.com".equalsIgnoreCase(studentEmail)) {
            return "Student with email " + studentEmail + " is not eligible for registration";
        }

        Registration registration = new Registration(studentEmail, courseId);
        registrationRepository.save(registration);

        return "Successfully registered student with email " + studentEmail + " for course with ID " + courseId;
    }

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public List<Registration> getRegistrationsByStudentEmail(String studentEmail) {
        return registrationRepository.findByStudentEmail(studentEmail);
    }

    public Optional<Registration> getRegistrationById(Long id) {
        return registrationRepository.findById(id);
    }
}
