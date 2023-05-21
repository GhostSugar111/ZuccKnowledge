package com.example.teachSystem.Serve;

import com.example.teachSystem.Entity.User;
import com.example.teachSystem.formbean.UserForm;

public interface UserService {
   UserForm addUser(User user);

    UserForm editUser(Integer id, UserForm userForm);

    UserForm getUserById(Integer id);

    void deleteUser(Integer id);

}
