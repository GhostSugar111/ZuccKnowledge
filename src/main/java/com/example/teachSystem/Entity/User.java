package com.example.teachSystem.Entity;

import javax.persistence.*;

@Entity
@Table(name = " user", schema = "zuccknowledge", catalog = "")
public class User {
    private String name;

    public User() {
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

    private Integer id;
    @Basic
    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
