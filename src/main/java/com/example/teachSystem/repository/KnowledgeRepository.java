package com.example.teachSystem.repository;

import com.example.teachSystem.Entity.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KnowledgeRepository extends JpaRepository<Knowledge, Integer> {
    @Query(value="select * from knowledge where id = ?", nativeQuery = true)
    Knowledge find_Id(String id);
    @Query(value="select * from knowledge where id = ?", nativeQuery = true)
    Knowledge delete_Id(String id);
}
