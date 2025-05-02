package com.example.pf.studentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    
    public Student registerStudent(Student student) {
        return studentRepository.save(student);  
    }

    
    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);  
    }

   
    public boolean isEligibleForCourse(String studentEmail) {
        Optional<Student> student = getStudentByEmail(studentEmail);

        
        return student.map(value -> value.getCredits() < 30)  
                .orElse(false);  
    }
}
