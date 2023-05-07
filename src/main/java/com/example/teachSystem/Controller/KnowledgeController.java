package com.example.teachSystem.Controller;

import com.example.teachSystem.Entity.Knowledge;
import com.example.teachSystem.Entity.ReadLog;
import com.example.teachSystem.Serve.KnowledgeService;
import com.example.teachSystem.formbean.KnowledgeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/knowledge")
public class KnowledgeController {

    private final KnowledgeService knowledgeService;

    @Autowired
    public KnowledgeController(KnowledgeService knowledgeService) {
        this.knowledgeService = knowledgeService;
    }

    // 新增方法：记录阅读记录
    @PostMapping("/{id}/readLog")
    public void addReadLog(@PathVariable Integer id, @RequestParam String reader) {
        knowledgeService.addReadLog(id, reader);
    }

    // 新增方法：获取阅读记录列表
    @GetMapping("/{id}/readLogs")
    public List<ReadLog> getReadLogs(@PathVariable Integer id, @RequestParam(defaultValue = "10") Integer limit,
                                     @RequestParam(defaultValue = "0") Integer offset) {
        return knowledgeService.getReadLogs(id, limit, offset);
    }

    // 新增方法：获取知识点阅读总数
    @GetMapping("/{id}/readCount")
    public Long getReadCount(@PathVariable Integer id) {
        return knowledgeService.getReadCount(id);
    }

    @PostMapping("/add")
    public KnowledgeForm saveKnowledge(@RequestBody Knowledge knowledge) {
        KnowledgeForm knowledgeForm=knowledgeService.saveKnowledge(knowledge);
        return knowledgeForm;
    }

    @GetMapping("/{id}")
    public Knowledge getKnowledgeById(@PathVariable Integer id) {
        return knowledgeService.getKnowledgeById(id);
    }

    @GetMapping("/")
    public List<Knowledge> getAllKnowledge() {
        return knowledgeService.getAllKnowledge();
    }

    @PutMapping("/update/{id}")
    public Knowledge updateKnowledge(@PathVariable Integer id, @RequestBody Knowledge knowledge) {
        return knowledgeService.updateKnowledge(id, knowledge);
    }

    @DeleteMapping("delete/{id}")
    public void deleteKnowledgeById(@PathVariable Integer id) {
        knowledgeService.deleteKnowledgeById(id);
    }

}
