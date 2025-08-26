package com.elegant.elagantschoolbackend.controllers;

import com.elegant.elagantschoolbackend.models.Notice;
import com.elegant.elagantschoolbackend.services.NoticesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class NoticesController {

    private NoticesService noticesService;

    public NoticesController(NoticesService noticesService){
        this.noticesService = noticesService;
    }

    @PostMapping("/notice")
    public ResponseEntity<?> addNewNotice(@RequestBody Notice notice){
        return noticesService.addNotice(notice);
    }

    @GetMapping("/notices")
    public ResponseEntity<Notice> getAllNotices(){
        return noticesService.getAllNotices();
    }
}
