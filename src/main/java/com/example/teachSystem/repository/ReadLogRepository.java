package com.example.teachSystem.repository;

import com.example.teachSystem.Entity.ReadLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadLogRepository extends JpaRepository<ReadLog, Long> {
    List<ReadLog> findByKnowledgeId(Long knowledgeId);
}
