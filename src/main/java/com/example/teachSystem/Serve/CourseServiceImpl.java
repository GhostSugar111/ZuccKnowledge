package com.example.teachSystem.Serve;

import com.example.teachSystem.Entity.Course;
import com.example.teachSystem.formbean.CourseForm;
import com.example.teachSystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseForm addCourse(Course course) {
        courseRepository.save(course);
        return new CourseForm(course);
    }

//    @Override
//    public CourseForm editCourse(Integer id, CourseForm courseForm) {
//        Course course = courseForm.toCourse();
//        course.setId(id);
//        course = courseRepository.save(course);
//        return new CourseForm(course);
//    }
    @Override
    public CourseForm editCourse(Integer id, CourseForm courseForm) {
        Course course=null;
        course=courseRepository.findByIdLike(id);
        if (course!=null) {
            course.setTag(courseForm.getTag());
            course.setTeacher(courseForm.getTeacher());
            course.setBook(courseForm.getBook());
            course.setIntro(courseForm.getIntro());
            course.setName(courseForm.getName());
            course.setKnowledge(courseForm.getKnowledge());
            courseRepository.save(course);
            return new CourseForm(course);
        } else {
            throw new RuntimeException("Course not found with id: " + id);
        }
    }

    @Override
    public CourseForm getCourseById(Integer id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            CourseForm courseForm = new CourseForm(course);
            return courseForm;
        }
        return null;
    }


    @Override
    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }

    @Override
    public CourseForm setCourseTags(Integer id, String tags) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            course.setTag(tags);
            course = courseRepository.save(course);
            return new CourseForm(course);
        }
        return null;
    }
}
