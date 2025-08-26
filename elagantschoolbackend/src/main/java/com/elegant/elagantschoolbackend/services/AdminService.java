package com.elegant.elagantschoolbackend.services;

import com.elegant.elagantschoolbackend.models.Admin;
import com.elegant.elagantschoolbackend.repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepo repo;

    public ResponseEntity<Admin> getAllAdmins() {
        return new ResponseEntity(repo.findAll(), HttpStatus.OK);
    }

    public void addAdmin(Admin admin) {
        repo.save(admin);
    }

    public ResponseEntity<String> verifyLogin(String username, String password) {

        Admin admin = repo.findByName(username);

        if(admin.getName().equals(username) && admin.getPassword().equals(password)){
            return ResponseEntity.ok("login successful");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid");
    }

    public ResponseEntity<Admin> findAdmin(String name) {
        return new ResponseEntity(repo.findByName(name),HttpStatus.OK);
    }

    public ResponseEntity<Admin> getAdminInfo(Integer id) {
        return new ResponseEntity(repo.findById(id),HttpStatus.OK);
    }
}
