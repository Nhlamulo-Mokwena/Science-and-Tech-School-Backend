package com.elegant.elagantschoolbackend.repositories;

import com.elegant.elagantschoolbackend.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepo extends JpaRepository<Grade,Integer> {
}
