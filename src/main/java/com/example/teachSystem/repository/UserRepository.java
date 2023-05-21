package com.example.teachSystem.repository;

import com.example.teachSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByIdLike(Integer id);
}
