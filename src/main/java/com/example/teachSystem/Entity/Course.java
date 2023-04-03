package com.example.teachSystem.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course", schema = "zuccknowledge", catalog = "")
public class Course {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @ManyToMany
    @JoinColumn(name="id")
    private List<Knowledge> knowledgeList;

    @ManyToMany
    @JoinColumn(name="id")
    private List<Tag> tagList;


    @Basic
    @Column(name = "intro")
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
    @Basic
    @Column(name = "book")
    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
    @Basic
    @Column(name = "tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    @Basic
    @Column(name = "teacher")
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    private String name;
    private Integer id;
    private String intro;
    private String book;
    private String tag;
    private String teacher;
    @Basic
    @Column(name = "knowledge")
    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    private String knowledge;
}
