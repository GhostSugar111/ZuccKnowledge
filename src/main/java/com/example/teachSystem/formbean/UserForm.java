package com.example.teachSystem.formbean;

import com.example.teachSystem.Entity.User;

public class UserForm {
    private Integer id;
    private String name;

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
    public UserForm(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
