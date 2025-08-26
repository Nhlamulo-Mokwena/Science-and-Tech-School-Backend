package com.elegant.elagantschoolbackend.repositories;

import com.elegant.elagantschoolbackend.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
