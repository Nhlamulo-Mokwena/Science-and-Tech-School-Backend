package com.elegant.elagantschoolbackend.controllers;
import com.elegant.elagantschoolbackend.models.Admin;
import com.elegant.elagantschoolbackend.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@CrossOrigin
@RestController
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping("/admins")
    public ResponseEntity<Admin> getAdmins(){
        return adminService.getAllAdmins();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("username") String username,
                                        @RequestParam("password") String password){
        return adminService.verifyLogin(username,password);
    }

    @PostMapping("/register")
    public void addAdmin(@RequestBody Admin admin){
        adminService.addAdmin(admin);
    }

    @GetMapping("/admin/{name}")
    public ResponseEntity<Admin> getAdmin(@PathVariable String name){
        return adminService.findAdmin(name);
    }

    @GetMapping("/data/{id}")
    public ResponseEntity<Admin> getAdmin(@PathVariable Integer id){
        System.out.println("calling method");
        return adminService.getAdminInfo(id);
    }

}
