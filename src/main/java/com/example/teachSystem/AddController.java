package com.example.teachSystem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("add")
public class AddController {
    @RequestMapping("/course")
    public String addCourse(Model model) throws Exception {
        model.addAttribute("title", "新建课程");
        return "/test";
    }
    @RequestMapping("/knowledgePoint")
    public String addKnowledgePoint (Model model) throws Exception {
        model.addAttribute("title", "新建知识点");
        return "/test";
    }
}
