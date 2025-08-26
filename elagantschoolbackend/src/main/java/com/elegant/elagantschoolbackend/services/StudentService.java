package com.elegant.elagantschoolbackend.services;

import com.elegant.elagantschoolbackend.models.Student;
import com.elegant.elagantschoolbackend.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public ResponseEntity<?> registerStudent(Student student) {
        return new ResponseEntity<>(studentRepo.save(student), HttpStatus.OK);
    }
}
