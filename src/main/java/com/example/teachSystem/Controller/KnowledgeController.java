package com.example.teachSystem.Controller;

import com.example.teachSystem.Entity.Knowledge;
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

//    @PutMapping("/addExample/{id}")
//    public KnowledgeForm addExample(@PathVariable Integer id, @RequestBody Knowledge knowledge) {
//        return knowledgeService.addExample(id, knowledge);
//    }
}
