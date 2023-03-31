package com.example.teachSystem.dao;

import com.example.teachSystem.Entity.Course;

public interface ICourseDao extends IDao<Course> {
    Course getCourseById(String id);
}
