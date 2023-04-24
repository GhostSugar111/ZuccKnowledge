package com.example.teachSystem.formbean;

import com.example.teachSystem.Entity.Knowledge;

public class KnowledgeForm {
    private Integer id;
    private String name;
    private String intro;
    private String keystatement;
    private String front;
    private String tags;
    private String correlation;
    private String example;

    public KnowledgeForm() {}

    public KnowledgeForm(Knowledge knowledge) {
        this.id = knowledge.getId();
        this.name = knowledge.getName();
        this.intro =  knowledge.getIntro();
        this.keystatement = knowledge.getKeystatement();
        this.front = knowledge.getFront();
        this.tags = knowledge.getTags();
        this.correlation = knowledge.getCorrelation();
        this.example = knowledge.getExample();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getKeystatement() {
        return keystatement;
    }

    public void setKeystatement(String keystatement) {
        this.keystatement = keystatement;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCorrelation() {
        return correlation;
    }

    public void setCorrelation(String correlation) {
        this.correlation = correlation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
