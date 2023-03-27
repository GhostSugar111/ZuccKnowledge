package com.example.teachSystem.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tag_group", schema = "zuccknowledge", catalog = "")
public class TagGroup {
    private Integer id;
    private String name;
    @Basic
    @Column(name="name")
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
    @Basic
    @Column(name="intro")
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    private String intro;

}
