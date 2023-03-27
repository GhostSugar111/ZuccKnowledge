package com.example.teachSystem.Controller;

import com.example.teachSystem.Entity.TagGroup;
import com.example.teachSystem.repository.CourseRepository;
import com.example.teachSystem.repository.KnowledgeRepository;
import com.example.teachSystem.repository.TagGroupRepository;
import com.example.teachSystem.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class tagGroupController {
    @Autowired
    private final CourseRepository courseRepository;
    private final KnowledgeRepository knowledgeRepository;
    private final TagRepository tagRepository;
    private final TagGroupRepository tagGroupRepository;

    tagGroupController(CourseRepository courseRepository,
                  KnowledgeRepository knowledgeRepository,
                  TagRepository tagRepository,
                  TagGroupRepository tagGroupRepository){
        this.knowledgeRepository = knowledgeRepository;
        this.tagRepository = tagRepository;
        this.tagGroupRepository = tagGroupRepository;
        this.courseRepository = courseRepository;
    }
    @PostMapping("/tagGroup/add")
    public TagGroup addTagGroup(@RequestBody Map<String, String> queryExample) {

        // 课程属性已经封装在tagGroup对象中，可以直接使用
        // 这里省略了数据库操作的代码
        TagGroup tagGroupEntity = new TagGroup();
        tagGroupEntity.setName(queryExample.get("name"));
        tagGroupEntity.setIntro(queryExample.get("intro"));
        tagGroupEntity = this.tagGroupRepository.save(tagGroupEntity);
        return tagGroupEntity;
    }
    @PutMapping("/tagGroup/update/{id}")
    public TagGroup editTagGroup(@PathVariable String id, @RequestBody Map<String, String> queryExample) {
        TagGroup tagGroupEntity=tagGroupRepository.find_Id(id);
        // 知识点属性已经封装在tagGroup对象中，可以直接使用
        // 这里省略了数据库操作的代码 先查找，然后更新记录
        if (queryExample.containsKey("name")) {
            tagGroupEntity.setName(queryExample.get("name"));
        }
        if (queryExample.containsKey("intro")) {
            tagGroupEntity.setIntro(queryExample.get("intro"));
        }
        tagGroupEntity = this.tagGroupRepository.save(tagGroupEntity);
        return tagGroupEntity;
    }
    @GetMapping("/tagGroup/{id}")
    public TagGroup searchTagGroup(@PathVariable String id) {
        TagGroup tagGroupEntity=tagGroupRepository.find_Id(id);

        // 知识点属性已经封装在tagGroup对象中，可以直接使用
        // 这里省略了数据库操作的代码 查询记录,然后赋值给tagGroup（尝试直接返回一个json）

        return tagGroupEntity;
    }
    @DeleteMapping("/tagGroup/delete/{id}")
    public TagGroup deleteTagGroup(@PathVariable String id) {
        TagGroup tagGroupEntity=tagGroupRepository.find_Id(id);
        tagGroupRepository.delete(tagGroupEntity);
        // 知识点属性已经封装在tagGroup对象中，可以直接使用
        // 这里省略了数据库操作的代码 查询记录,然后赋值给tagGroup（尝试直接返回一个json）

        return tagGroupEntity;
    }
}
