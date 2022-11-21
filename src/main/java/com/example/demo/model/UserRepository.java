package com.example.demo.model;

import com.example.demo.model.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{


    User findByEmail(String email);
}
