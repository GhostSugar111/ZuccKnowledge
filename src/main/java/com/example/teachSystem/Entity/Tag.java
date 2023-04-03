package com.example.teachSystem.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tag", schema = "zuccknowledge", catalog = "")
public class Tag {
    private String name;
    private String intro;
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
    @ManyToOne
    @JoinColumn(name="id")
    private TagGroup tagGroup;
    @Basic
    @Column(name="groupName")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    private String groupName;
    @Basic
    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Basic
    @Column(name="intro")
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
