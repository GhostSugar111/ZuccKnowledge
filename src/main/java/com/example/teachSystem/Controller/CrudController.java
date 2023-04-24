package com.example.teachSystem.Controller;

import com.example.teachSystem.Entity.Course;
import com.example.teachSystem.Entity.Knowledge;
import com.example.teachSystem.Entity.Tag;
import com.example.teachSystem.Entity.TagGroup;
import com.example.teachSystem.formbean.CourseForm;
import com.example.teachSystem.repository.CourseRepository;
import com.example.teachSystem.repository.KnowledgeRepository;
import com.example.teachSystem.repository.TagGroupRepository;
import com.example.teachSystem.repository.TagRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengbin
 * @version 1.0
 */
@RestController
public class CrudController {

    private final CourseRepository courseRepository;
    private final KnowledgeRepository knowledgeRepository;
    private final TagRepository tagRepository;
    private final TagGroupRepository tagGroupRepository;

    CrudController(CourseRepository courseRepository,
                   KnowledgeRepository knowledgeRepository,
                   TagRepository tagRepository,
                   TagGroupRepository tagGroupRepository){
        this.knowledgeRepository = knowledgeRepository;
        this.tagRepository = tagRepository;
        this.tagGroupRepository = tagGroupRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/crud")
    List<CourseForm> excuteBasicCrud(){
        //创建1个标签组
        TagGroup TagGroupEntity = new TagGroup();
        TagGroupEntity.setName("便签组" + RandomStringUtils.randomAlphabetic(2));
        TagGroupEntity=this.tagGroupRepository.save(TagGroupEntity);

        //创建1个标签
        Tag TagEntity = new Tag();
        TagEntity.setName("标签" + RandomStringUtils.randomAlphabetic(4));
        TagEntity.setGroupName(TagGroupEntity.getName());
        TagEntity=this.tagRepository.save(TagEntity);

        //创建一个知识点
        Knowledge knowledgeEntity = new Knowledge();
        knowledgeEntity.setName("知识点" + RandomStringUtils.randomNumeric(3));
        knowledgeEntity = this.knowledgeRepository.save(knowledgeEntity);

        //创建一个课程
        Course courseEntity = new Course();
        courseEntity.setName("课程" + RandomStringUtils.randomNumeric(6));
        courseEntity.setTeacher("教师" + RandomStringUtils.randomAlphabetic(6));
        courseEntity.setKnowledge(knowledgeEntity.getName());
        courseEntity.setTag(TagEntity.getName());
        courseEntity = this.courseRepository.save(courseEntity);


        //检索出所有的课程
        List<Course> allCourse = this.courseRepository.findAll();
        List<CourseForm> courseList = new ArrayList<>();
        allCourse.stream().forEach(item -> {
            CourseForm q = new CourseForm();
            BeanUtils.copyProperties(item, q);
            courseList.add(q);
        });

        return courseList;
    }
}
