package com.example.teachSystem.Controller;

import com.example.teachSystem.Entity.Knowledge;
import com.example.teachSystem.repository.CourseRepository;
import com.example.teachSystem.repository.KnowledgeRepository;
import com.example.teachSystem.repository.TagGroupRepository;
import com.example.teachSystem.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class knowledgeController {
    @Autowired
    private final CourseRepository courseRepository;
    private final KnowledgeRepository knowledgeRepository;
    private final TagRepository tagRepository;
    private final TagGroupRepository tagGroupRepository;

    knowledgeController(CourseRepository courseRepository,
                        KnowledgeRepository knowledgeRepository,
                        TagRepository tagRepository,
                        TagGroupRepository tagGroupRepository){
        this.knowledgeRepository = knowledgeRepository;
        this.tagRepository = tagRepository;
        this.tagGroupRepository = tagGroupRepository;
        this.courseRepository = courseRepository;
    }
    @PostMapping("/knowledge/add")
    public Knowledge addKnowledge(@RequestBody Map<String, String> queryExample) {

        // 知识点属性已经封装在knowledge对象中，可以直接使用
        // 这里省略了数据库操作的代码 先查找，无则写入一条记录
        Knowledge knowledgeEntity = new Knowledge();
        knowledgeEntity.setName(queryExample.get("name"));
        knowledgeEntity.setExample(queryExample.get("example"));
        knowledgeEntity.setCorrelation(queryExample.get("correlation"));
        knowledgeEntity.setIntro(queryExample.get("intro"));
        knowledgeEntity.setKeystatement(queryExample.get("keystatement"));
        knowledgeEntity.setFront(queryExample.get("front"));
        knowledgeEntity.setTags(queryExample.get("tags"));
        knowledgeEntity = this.knowledgeRepository.save(knowledgeEntity);
        return knowledgeEntity;
    }
    @PutMapping("/knowledge/update/{id}")
    public Knowledge editKnowledge(@PathVariable String id, @RequestBody Map<String, String> queryExample) {

        // 知识点属性已经封装在knowledge对象中，可以直接使用
        // 这里省略了数据库操作的代码 先查找，然后更新记录
        Knowledge knowledgeEntity = knowledgeRepository.find_Id(id);
        knowledgeEntity = this.knowledgeRepository.save(knowledgeEntity);
        if (queryExample.containsKey("name")) {
            knowledgeEntity.setName(queryExample.get("name"));
        }
        if (queryExample.containsKey("example")) {
            knowledgeEntity.setExample(queryExample.get("example"));
        }
        if (queryExample.containsKey("correlation")) {
            knowledgeEntity.setCorrelation(queryExample.get("correlation"));
        }
        if (queryExample.containsKey("intro")) {
            knowledgeEntity.setIntro(queryExample.get("intro"));
        }
        if (queryExample.containsKey("tags")) {
            knowledgeEntity.setTags(queryExample.get("tags"));
        }
        if (queryExample.containsKey("keystatement")) {
            knowledgeEntity.setKeystatement(queryExample.get("keystatement"));
        }
        if (queryExample.containsKey("front")) {
            knowledgeEntity.setFront(queryExample.get("front"));
        }
        knowledgeEntity = this.knowledgeRepository.save(knowledgeEntity);
        return knowledgeEntity;
    }
    @GetMapping("/knowledge/{id}")
    public Knowledge searchknowledge(@PathVariable String id) {
        Knowledge knowledgeEntity = knowledgeRepository.find_Id(id);
        // 知识点属性已经封装在knowledge对象中，可以直接使用
        // 这里省略了数据库操作的代码 查询记录,然后赋值给knowledge（尝试直接返回一个json）

        return knowledgeEntity;
    }
    @DeleteMapping("/knowledge/delete/{id}")
    Knowledge deleteknowledge(@PathVariable String id) {
        Knowledge knowledgeEntity = knowledgeRepository.find_Id(id);
        this.knowledgeRepository.delete(knowledgeEntity);
        // 知识点属性已经封装在knowledge对象中，可以直接使用
        // 这里省略了数据库操作的代码 查询记录，有则赋值给knowledge并删除记录（尝试直接返回一个json）

        return knowledgeEntity;
    }
    @PutMapping("/knowledge/addExample/{id}")
    public Knowledge addExample(@PathVariable String id, @RequestBody Map<String, String> queryExample) {

        // 知识点属性已经封装在knowledge对象中，可以直接使用
        // 这里省略了数据库操作的代码 先查找，然后更新记录
        Knowledge knowledgeEntity = knowledgeRepository.find_Id(id);
        knowledgeEntity.setExample(knowledgeEntity.getExample()+queryExample.get("example")+";");
        knowledgeEntity = this.knowledgeRepository.save(knowledgeEntity);
        return knowledgeEntity;
    }
    @PutMapping("/knowledge/deleteExample/{id}")
    public Knowledge deleteExample(@PathVariable String id, @RequestBody Map<String, String> queryExample) {

        // 知识点属性已经封装在knowledge对象中，可以直接使用
        // 这里省略了数据库操作的代码 先查找，然后更新记录
        Knowledge knowledgeEntity = knowledgeRepository.find_Id(id);
        knowledgeEntity.setExample(knowledgeEntity.getExample().replace(queryExample.get("example")+";",""));
        knowledgeEntity = this.knowledgeRepository.save(knowledgeEntity);
        return knowledgeEntity;
    }
    @PutMapping("/knowledge/setCorrelation/{id}")
    public Knowledge setCorrelation(@PathVariable String id, @RequestBody Map<String, String> queryExample) {

        // 知识点属性已经封装在knowledge对象中，可以直接使用
        // 这里省略了数据库操作的代码 先查找，然后更新记录
        Knowledge knowledgeEntity = knowledgeRepository.find_Id(id);
        knowledgeEntity.setExample(knowledgeEntity.getExample()+queryExample.get("correlation")+";");
        knowledgeEntity = this.knowledgeRepository.save(knowledgeEntity);
        return knowledgeEntity;
    }
    @PutMapping("/knowledge/setTag/{id}")
    public Knowledge setknowledge(@PathVariable String id, @RequestBody Map<String, String> queryExample) {

        // 知识点属性已经封装在knowledge对象中，可以直接使用
        // 这里省略了数据库操作的代码 先查找，然后更新记录
        Knowledge knowledgeEntity = knowledgeRepository.find_Id(id);
        knowledgeEntity.setExample(knowledgeEntity.getExample()+queryExample.get("tags")+";");
        knowledgeEntity = this.knowledgeRepository.save(knowledgeEntity);
        return knowledgeEntity;
    }
}
