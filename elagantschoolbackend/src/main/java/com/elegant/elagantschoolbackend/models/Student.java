package com.elegant.elagantschoolbackend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentNo;
    private String name;
    private String surname;
    private int age;
    private String gender;
    private String guardianName;
    private String guardianEmail;
    private int gradeId;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    public Student(int studentNo, String name, String surname, int age, String gender,  String guardianName, String guardianEmail, int gradeId) {
        this.studentNo = studentNo;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.guardianEmail = guardianEmail;
        this.guardianName = guardianName;
        this.gradeId = gradeId;
        this.registrationDate = new Date();
    }
}
