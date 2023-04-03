package com.example.teachSystem.Serve;

import com.example.teachSystem.Entity.Course;
import com.example.teachSystem.dao.ICourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final ICourseDao courseDao;

    @Autowired
    public CourseService(ICourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public Course getCourseById(String id) {
        Course course=courseDao.getCourseById(id);
        return course;
//        return courseDao.getCourseById(id);
    }

    // 其他操作课程的方法
}
