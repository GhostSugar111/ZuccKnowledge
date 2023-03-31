package com.example.teachSystem.dao;

import com.example.teachSystem.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CourseDaoImpl extends Dao<Course> implements ICourseDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Course getCourseById(String id) {
        return entityManager.find(Course.class, id);
    }
}
