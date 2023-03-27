package com.example.teachSystem.repository;

import com.example.teachSystem.Entity.TagGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TagGroupRepository extends JpaRepository<TagGroup, Integer> {
    @Query(value="select * from tag_group where id = ?", nativeQuery = true)
    TagGroup find_Id(String id);

}
