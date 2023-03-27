package com.example.teachSystem.repository;

import com.example.teachSystem.Entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    @Query(value="select * from tag where id = ?", nativeQuery = true)
    Tag find_Id(String id);
}
