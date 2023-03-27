package com.example.teachSystem.repository;

import com.example.teachSystem.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository  extends JpaRepository<Course, Integer>{

    @Query(value="select * from course where id = ?", nativeQuery = true)
    Course find_Id(String id);

//    Boolean deleteById(String id);
    @Query(value="delete from course where id = ?", nativeQuery = true)
    Boolean delete_Id(String id);
}
