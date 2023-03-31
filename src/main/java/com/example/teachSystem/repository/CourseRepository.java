package com.example.teachSystem.repository;

import com.example.teachSystem.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    // 根据课程id查询课程
    @Query(value="select * from course where id = ?", nativeQuery = true)
    Course findById(String id);

    // 根据课程id删除课程
    @Query(value="delete from course where id = ?", nativeQuery = true)
    void deleteById(String id);
}
