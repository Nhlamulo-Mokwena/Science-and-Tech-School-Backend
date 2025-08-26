package com.elegant.elagantschoolbackend.repositories;

import com.elegant.elagantschoolbackend.models.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepo extends JpaRepository<Notice,Integer> {
}
