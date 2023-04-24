package com.example.teachSystem.Serve;

import com.example.teachSystem.Entity.Course;
import com.example.teachSystem.formbean.CourseForm;

public interface CourseService {

    CourseForm addCourse(Course course);

    CourseForm editCourse(Integer id, CourseForm courseForm);

    CourseForm getCourseById(Integer id);

    void deleteCourse(Integer id);

    CourseForm setCourseTags(Integer id, String tags);

}
