package com.elegant.elagantschoolbackend.controllers;

import com.elegant.elagantschoolbackend.models.Student;
import com.elegant.elagantschoolbackend.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public ResponseEntity<?> registerStudent(@RequestBody Student student){
        return studentService.registerStudent(student);
    }
}
