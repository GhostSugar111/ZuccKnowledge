package com.example.teachSystem.Controller;

import com.example.teachSystem.Entity.Knowledge;
import com.example.teachSystem.Entity.ReadLog;
import com.example.teachSystem.Serve.KnowledgeService;
import com.example.teachSystem.Serve.RedisService;
import com.example.teachSystem.formbean.KnowledgeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/knowledge")
public class KnowledgeController {

    private final KnowledgeService knowledgeService;
    private final RedisService redisService;
    @Autowired
    public KnowledgeController(KnowledgeService knowledgeService, RedisService redisService) {
        this.knowledgeService = knowledgeService;
        this.redisService = redisService;
    }

    // 记录阅读记录
    @PostMapping("/{id}/readLog")
    public void addReadLog(@PathVariable Integer id, @RequestParam String reader) {
        knowledgeService.addReadLog(id, reader);
        addAccessCount(id); // 增加知识点的访问量
    }

    // 获取阅读记录列表
    @GetMapping("/{id}/readLogs")
    public List<ReadLog> getReadLogs(@PathVariable Integer id, @RequestParam(defaultValue = "10") Integer limit,
                                     @RequestParam(defaultValue = "0") Integer offset) {
        return knowledgeService.getReadLogs(id, limit, offset);
    }

    // 获取知识点阅读总数
    @GetMapping("/{id}/readCount")
    public Long getReadCount(@PathVariable Integer id) {
        return knowledgeService.getReadCount(id);
    }
    // 获取知识点热度排名
    @GetMapping("/hotRank")
    public List<Knowledge> getHotRank() {
        List<String> hotKnowledgeIds = redisService.getList("hotKnowledge", 0, 9);
        List<Integer> hotKnowledgeIdInts = hotKnowledgeIds.stream().map(Integer::parseInt).collect(Collectors.toList());
        return knowledgeService.getKnowledgesByIds(hotKnowledgeIdInts);
    }

    @PostMapping("/{id}/accessCount")
    public void addAccessCount(@PathVariable Integer id) {
        String key = String.valueOf(id);
        Long accessCount = Long.valueOf(redisService.get(key)); // 获取已有的访问量
        if (accessCount == null) {
            accessCount = 0L;
        }
        accessCount++; // 增加访问量
        redisService.set(key, String.valueOf(accessCount)); // 更新访问量
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

    @GetMapping("/{id}/prerequisites")
    public List<Knowledge> getPrerequisites(@PathVariable Integer id) {
        return knowledgeService.getPrerequisites(id);
    }
}
