package com.elegant.elagantschoolbackend.services;

import com.elegant.elagantschoolbackend.models.Grade;
import com.elegant.elagantschoolbackend.models.Subject;
import com.elegant.elagantschoolbackend.repositories.GradeRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeRepo repo;

    public ResponseEntity<?> addGrade(Grade grade, MultipartFile file) throws IOException {
        grade.setImage(file.getBytes());
        grade.setImageName(file.getOriginalFilename());
        grade.setImageType(file.getContentType());
        return new ResponseEntity<>(repo.save(grade), HttpStatus.OK);
    }

    public List<Grade> getAllGrades() {
        return repo.findAll();
    }

    public ResponseEntity<?> addSubjectToGrade(int gradeId, Subject subject) {
        Grade grade = repo.findById(gradeId)
                        .orElseThrow(() ->
                                new EntityNotFoundException("Grade with id " + gradeId + " not found"));

        grade.addSub(subject);
        repo.save(grade);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Grade> getGrade(int id) {
        return new ResponseEntity<>(repo.findById(id).orElse(null),
                HttpStatus.OK);
    }

    public ResponseEntity<byte[]> getImage(int id) {
        return new ResponseEntity(repo.findById(id).get().getImage(),HttpStatus.OK);
    }

    public ResponseEntity<?> removeSubject(int gradeId, int subjectId) {
        Grade grade = repo.findById(gradeId).orElseThrow(() -> new EntityNotFoundException(
                "grade id is not found!"
        ));

        for(int i = 0; i < grade.getSubjectList().size(); i++){
            if(grade.getSubjectList().get(i).getId() == subjectId){
                grade.removeSub(grade.getSubjectList().get(i));
                break;
            }
        }

        repo.save(grade);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> updateSubject(int gradeId, Subject subject) {
        Grade grade = repo.findById(gradeId).orElseThrow(() ->
                new EntityNotFoundException(String.valueOf(HttpStatus.BAD_REQUEST)));

        grade.getSubjectList().forEach(s -> {
            if(s.getId() == subject.getId()){
                s.setName(subject.getName());
                s.setDescription(subject.getDescription());
            }
        });

        repo.save(grade);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Subject> getSubject(int gradeId, int subjectId) {

        Subject subject = new Subject();

        Grade grade = repo.findById(gradeId).orElseThrow(() ->
                new EntityNotFoundException(String.valueOf(HttpStatus.BAD_REQUEST)));

        for(int i = 0; i < grade.getSubjectList().size(); i++){
            if(grade.getSubjectList().get(i).getId() == subjectId){
                subject = grade.getSubjectList().get(i);
                break;
            }
        }

        return new ResponseEntity<>(subject,HttpStatus.OK);
    }
}
