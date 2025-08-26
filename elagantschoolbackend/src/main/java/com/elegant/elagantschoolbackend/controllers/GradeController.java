package com.elegant.elagantschoolbackend.controllers;

import com.elegant.elagantschoolbackend.models.Grade;
import com.elegant.elagantschoolbackend.models.Subject;
import com.elegant.elagantschoolbackend.services.GradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class GradeController {

    private GradeService gradeService;

    public GradeController(GradeService gradeService){
        this.gradeService = gradeService;
    }

    @PostMapping("/grade")
    public ResponseEntity<?> addGrade(@RequestPart Grade grade,
                                      @RequestPart MultipartFile imageFile){
        try {
            return gradeService.addGrade(grade,imageFile                        );
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/grades")
    public List<Grade> getAllGrades(){
        return gradeService.getAllGrades();
    }

    @GetMapping("/subject/{gradeId}/{subjectId}")
    public ResponseEntity<Subject> getSubject(@PathVariable int gradeId,
                                              @PathVariable int subjectId){
        return gradeService.getSubject(gradeId,subjectId);
    }

    @GetMapping("/grade/{id}")
    public ResponseEntity<Grade> getGrade(@PathVariable int id){
        return gradeService.getGrade(id);
    }

    @PostMapping("/subject/{gradeId}")
    public ResponseEntity<?> addGrade(@PathVariable int gradeId,
                                      @RequestBody Subject subject){
        System.out.println(subject);
        return gradeService.addSubjectToGrade(gradeId,subject);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@RequestPart int id){
        return gradeService.getImage(id);
    }

    @DeleteMapping("/delete/subject/{gradeId}/{subjectId}")
    public ResponseEntity<?> deleteSubject(@PathVariable int gradeId,
                                           @PathVariable int subjectId){
        return gradeService.removeSubject(gradeId,subjectId);
    }

    @PutMapping("/update/subject/{gradeId}")
    public ResponseEntity<?> updateSubject(@PathVariable int gradeId,
                                           @RequestBody Subject subject){
        return gradeService.updateSubject(gradeId,subject);
    }
}
