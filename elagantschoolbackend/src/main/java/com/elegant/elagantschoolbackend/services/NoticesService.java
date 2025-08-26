package com.elegant.elagantschoolbackend.services;

import com.elegant.elagantschoolbackend.models.Notice;
import com.elegant.elagantschoolbackend.repositories.NoticeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NoticesService {

    @Autowired
    private NoticeRepo noticeRepo;

    public ResponseEntity<?> addNotice(Notice notice) {
        return new ResponseEntity<>(noticeRepo.save(notice), HttpStatus.OK);
    }

    public ResponseEntity<Notice> getAllNotices() {
        return new ResponseEntity(noticeRepo.findAll(),HttpStatus.OK);
    }
}
