package com.example.teachSystem.Serve;

import com.example.teachSystem.Entity.User;
import com.example.teachSystem.formbean.UserForm;
import com.example.teachSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserForm addUser(User user) {
        userRepository.save(user);
        return new UserForm(user);
    }
    @Override
    public UserForm editUser(Integer id, UserForm userForm) {
        User user=null;
        user=userRepository.findByIdLike(id);
        if (user!=null) {
            user.setName(userForm.getName());
            return new UserForm(user);

        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
    @Override
    public UserForm getUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserForm userForm = new UserForm(user);
            return userForm;
        }
        return null;

    }

    @Override
    public void deleteUser(Integer id) {userRepository.deleteById(id);
    }
}
