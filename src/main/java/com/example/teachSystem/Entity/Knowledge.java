package com.example.teachSystem.Entity;

import javax.persistence.*;

@Entity
@Table(name = "knowledge", schema = "zuccknowledge", catalog = "")
public class Knowledge {
    private String name;//名字、id、描述、重点说明、案例、前置知识点、标签、关联知识点
    @Basic
    @Column(name = "correlation")
    public String getCorrelation() {
        return correlation;
    }

    public void setCorrelation(String correlation) {
        this.correlation = correlation;
    }

    private String correlation;
    @Basic
    @Column(name = "example")
    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    private String example;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    private String intro;
    private String keystatement;
    private String front;
    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Basic
    @Column(name = "intro")
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
    @Basic
    @Column(name = "keystatement")
    public String getKeystatement() {
        return keystatement;
    }

    public void setKeystatement(String keystatement) {
        this.keystatement = keystatement;
    }
    @Basic
    @Column(name = "front")
    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }
    @Basic
    @Column(name = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    private String tags;
}
