package com.example.teachSystem.Controller;

import com.example.teachSystem.Entity.Course;
import com.example.teachSystem.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class courseController {
    private final CourseRepository courseRepository;

    public courseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @PutMapping("/{id}")
    public Course editCourse(@PathVariable String id, @RequestBody Course course) {
        course.setId(Integer.valueOf(id));
        return courseRepository.save(course);
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseRepository.deleteById(id);
    }

    @PutMapping("/{id}/tags")
    public Course setCourseTags(@PathVariable String id, @RequestBody List<String> tags) {
        Course course = courseRepository.findById(id);
        if (course != null) {
            course.setTag(String.join(",", tags));
            course = courseRepository.save(course);
        }
        return course;
    }
}
//package com.example.teachSystem.Controller;
//
//import com.example.teachSystem.Entity.Course;
//import com.example.teachSystem.repository.CourseRepository;
//import com.example.teachSystem.repository.KnowledgeRepository;
//import com.example.teachSystem.repository.TagGroupRepository;
//import com.example.teachSystem.repository.TagRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//
//@RestController
//public class courseController {
//    @Autowired
//    private final CourseRepository courseRepository;
//    private final KnowledgeRepository knowledgeRepository;
//    private final TagRepository tagRepository;
//    private final TagGroupRepository tagGroupRepository;
//
//    courseController(CourseRepository courseRepository,
//                   KnowledgeRepository knowledgeRepository,
//                   TagRepository tagRepository,
//                   TagGroupRepository tagGroupRepository){
//        this.knowledgeRepository = knowledgeRepository;
//        this.tagRepository = tagRepository;
//        this.tagGroupRepository = tagGroupRepository;
//        this.courseRepository = courseRepository;
//    }
//    @PostMapping("/course/add")
//    Course addCourse(@RequestBody Map<String, String> queryExample ) {
//
//        // 课程属性已经封装在course对象中，可以直接使用
//        // 这里省略了数据库操作的代码 先查找，无则写入一条记录
//            Course courseEntity = new Course();
//            courseEntity.setName(queryExample.get("name"));
//            courseEntity.setTeacher(queryExample.get("teacher"));
//            courseEntity.setKnowledge(queryExample.get("knowledge"));
//            courseEntity.setIntro(queryExample.get("intro"));
//            courseEntity.setTag(queryExample.get("tags"));
//            courseEntity.setBook(queryExample.get("book"));
//            courseEntity = this.courseRepository.save(courseEntity);
//
//
////        //检索出所有的课程
////        List<Course> allCourse = this.courseRepository.findAll();
////        List<Coursebean> courseList = new ArrayList<>();
////        allCourse.stream().forEach(item -> {
////            Coursebean q = new Coursebean();
////            BeanUtils.copyProperties(item, q);
////            courseList.add(q);
////        });
//        return courseEntity;
//    }
//    @PutMapping("/course/update/{id}")
//    Course editCourse(@PathVariable String id, @RequestBody Map<String, String> queryExample) {
//
//        // 课程id已经从路径中获取，课程属性已经封装在course对象中，可以直接使用
//        // 这里省略了数据库操作的代码 先查找，然后更新记录
//            Course courseEntity = courseRepository.find_Id(id);
//            if (queryExample.containsKey("name")) {
//                courseEntity.setName(queryExample.get("name"));
//            }
//            if (queryExample.containsKey("teacher")) {
//                courseEntity.setTeacher(queryExample.get("teacher"));
//            }
//            if (queryExample.containsKey("knowledge")) {
//                courseEntity.setKnowledge(queryExample.get("knowledge"));
//            }
//            if (queryExample.containsKey("intro")) {
//                courseEntity.setIntro(queryExample.get("intro"));
//            }
//            if (queryExample.containsKey("tags")) {
//                courseEntity.setTag(queryExample.get("tags"));
//            }
//            if (queryExample.containsKey("book")) {
//                courseEntity.setBook(queryExample.get("book"));
//            }
//            courseEntity = this.courseRepository.save(courseEntity);
//
//        return courseEntity;
//    }
//    @GetMapping("/course/{id}")
//    public Course searchCourse(@PathVariable String id) {
//        Course courseEntity = courseRepository.find_Id(id);
//
//        // 课程id已经从路径中获取
//        // 这里省略了数据库操作的代码，查询记录,然后赋值给course（尝试直接返回一个json）
//
//
//        return courseEntity;
//    }
//    @DeleteMapping("/course/delete/{id}")
//    Course deleteCourse(@PathVariable String id) {
//
//        // 课程id已经从路径中获取
//        // 这里省略了数据库操作的代码，查询记录，有则赋值给course并删除记录（尝试直接返回一个json）
//
//        // 如果删除成功，返回200状态码和成功信息
//        Course courseEntity = courseRepository.find_Id(id);
////        this.courseRepository.delete(courseEntity);
//        this.courseRepository.deleteById(Integer.parseInt(id));
//        return courseEntity;
//    }
//    @PutMapping("/course/setTag/{id}")
//    public Course setCourse(@PathVariable String id, @RequestBody Map<String, String> queryExample) {
//
//        // 课程id已经从路径中获取，课程属性已经封装在course对象中，可以直接使用
//        // 这里省略了数据库操作的代码 先查找，然后更新记录
//        Course courseEntity = courseRepository.find_Id(id);
//        courseEntity.setTag(queryExample.get("tags"));
//        courseEntity=this.courseRepository.save(courseEntity);
//        return courseEntity;
//    }
//}


