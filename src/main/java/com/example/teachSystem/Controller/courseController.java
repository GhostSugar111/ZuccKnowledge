package com.example.teachSystem.Controller;

import com.example.teachSystem.Entity.Course;
import com.example.teachSystem.Response.CourseResponse;
import com.example.teachSystem.Serve.CourseService;
import com.example.teachSystem.formbean.CourseForm;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/course")
public class courseController {

    private final CourseService courseService;

    public courseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping("/add")
    public CourseResponse addCourse(@RequestBody Course course) {
        CourseForm courseForm = courseService.addCourse(course);
        return new CourseResponse(HttpStatus.OK.value(), "添加成功", courseForm);
    }

    @PutMapping("update/{id}")
    public CourseResponse editCourse(@PathVariable Integer id, @RequestBody CourseForm courseForm) {
        CourseForm updatedCourseForm = courseService.editCourse(id, courseForm);
        return new CourseResponse(HttpStatus.OK.value(), "更新成功", updatedCourseForm);
    }

    @GetMapping("/{id}")
    public CourseResponse getCourse(@PathVariable Integer id) {
        CourseForm courseForm = courseService.getCourseById(id);
        return new CourseResponse(HttpStatus.OK.value(), "查询成功", courseForm);
    }

    @DeleteMapping("/delete/{id}")
    public CourseResponse deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return new CourseResponse(HttpStatus.OK.value(), "删除成功", null);
    }

    @PutMapping("setTag/{id}")
    public CourseResponse setCourseTags(@PathVariable Integer id, @RequestBody Map<String, String> requestBody) {
        String tagsStr = requestBody.get("tag");
        if (tagsStr != null) {
            CourseForm updatedCourseForm = courseService.setCourseTags(id, tagsStr);
            return new CourseResponse(HttpStatus.OK.value(), "设置标签成功", updatedCourseForm);
        } else {
            return new CourseResponse(HttpStatus.BAD_REQUEST.value(), "标签不能为空", null);
        }
    }

}
