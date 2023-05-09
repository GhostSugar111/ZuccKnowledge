package com.example.teachSystem.repository;

import com.example.teachSystem.Entity.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KnowledgeRepository extends JpaRepository<Knowledge, Integer> {
    @Query(value="select * from knowledge where id = ?", nativeQuery = true)
    Knowledge find_Id(String id);
    @Query(value="select * from knowledge where id = ?", nativeQuery = true)
    Knowledge delete_Id(String id);
    List<Knowledge> findByIdIn(List<Integer> ids);

}
