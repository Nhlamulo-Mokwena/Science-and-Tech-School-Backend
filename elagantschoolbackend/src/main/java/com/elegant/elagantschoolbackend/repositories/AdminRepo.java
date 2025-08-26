package com.elegant.elagantschoolbackend.repositories;

import com.elegant.elagantschoolbackend.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin,Integer> {

    @Query("select a from Admin a where a.name = :name")
    Admin findByName(String name);
}
