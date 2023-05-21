package com.example.teachSystem.Controller;

import com.example.teachSystem.Entity.Tag;
import com.example.teachSystem.repository.CourseRepository;
import com.example.teachSystem.repository.KnowledgeRepository;
import com.example.teachSystem.repository.TagGroupRepository;
import com.example.teachSystem.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class tagController {
    @Autowired
    private final CourseRepository courseRepository;
    private final KnowledgeRepository knowledgeRepository;
    private final TagRepository tagRepository;
    private final TagGroupRepository tagGroupRepository;

    tagController(CourseRepository courseRepository,
                  KnowledgeRepository knowledgeRepository,
                  TagRepository tagRepository,
                  TagGroupRepository tagGroupRepository){
        this.knowledgeRepository = knowledgeRepository;
        this.tagRepository = tagRepository;
        this.tagGroupRepository = tagGroupRepository;
        this.courseRepository = courseRepository;
    }
    @PostMapping("/tag/add")
    public Tag addTag(@RequestBody Map<String, String> queryExample) {

        // 课程属性已经封装在tag对象中，可以直接使用
        // 这里省略了数据库操作的代码
        Tag tagEntity = new Tag();
        tagEntity.setName(queryExample.get("name"));
        tagEntity.setGroupName(queryExample.get("group_name"));
        tagEntity.setIntro(queryExample.get("intro"));
        tagEntity.setIsBuiltIn(Boolean.parseBoolean(queryExample.get("isBuiltln")));
        tagEntity = this.tagRepository.save(tagEntity);
        return tagEntity;
    }
    @PutMapping("/tag/update/{id}")
    public Tag editTag(@PathVariable String id,@RequestBody Map<String, String> queryExample) {

        // 知识点属性已经封装在tag对象中，可以直接使用
        // 这里省略了数据库操作的代码 先查找，然后更新记录
        Tag tagEntity = tagRepository.find_Id(id);
        if (queryExample.containsKey("name")) {
            tagEntity.setName(queryExample.get("name"));
        }
        if (queryExample.containsKey("group_name")) {
            tagEntity.setGroupName(queryExample.get("group_name"));
        }
        if (queryExample.containsKey("intro")) {
            tagEntity.setIntro(queryExample.get("intro"));
        }
        tagEntity = this.tagRepository.save(tagEntity);
        return tagEntity;
    }
    @GetMapping("/tag/{id}")
    public Tag searchTag(@PathVariable String id) {
        Tag tagEntity = tagRepository.find_Id(id);

        // 知识点属性已经封装在tag对象中，可以直接使用
        // 这里省略了数据库操作的代码 查询记录,然后赋值给knowledge（尝试直接返回一个json）

        return tagEntity;
    }
    @DeleteMapping("/tag/delete/{id}")
    public Tag deleteTag(@PathVariable String id) {
        Tag tagEntity=tagRepository.find_Id(id);
        if (tagEntity != null) {
            // 如果是系统内置标签则禁止删除
            if (tagEntity.getIsBuiltIn()) {
                throw new RuntimeException("内置标签不能被删除！");
            }
            this.tagRepository.delete(tagEntity);
        }
        return tagEntity;
    }
    @PutMapping("/tag/setGroup/{id}")
    public Tag setTagGroup(@PathVariable String id,@RequestBody Map<String, String> queryExample) {
        Tag tagEntity=tagRepository.find_Id(id);
        tagEntity.setGroupName(queryExample.get("tag_group"));
        // 知识点属性已经封装在tag对象中，可以直接使用
        // 这里省略了数据库操作的代码 先查找，然后更新记录

        return tagEntity;
    }
}