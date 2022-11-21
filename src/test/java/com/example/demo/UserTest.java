package com.example.demo;

import com.example.demo.model.UserRepository;
import com.example.demo.model.data.User;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void addUser(){
        User user = User.builder()
                .firstName("Apig")
                .lastName("Aramian")
                .email("abik_aramian@edu.aua.am")
                .build();

        userRepository.save(user);

        Assertions.assertThat(user.getId()) .isGreaterThan(0);
    }

    @Test
    public void getUsers(){
        User user = userRepository.findById(1L).get();

        Assertions.assertThat(user.getId()).isEqualTo(1L);
    }

    @Test
    public void getListUser(){
        List<User> users = userRepository.findAll();
        Assertions.assertThat(users.size()).isGreaterThan(0);
    }

    @Test
    public void updateUser(){
        User user = userRepository.findById(1L).get();
        user.setEmail("apigaramian22@gmail.com");
        User newUser = userRepository.save(user);
        Assertions.assertThat(newUser.getEmail()).isEqualTo("apigaramian22@gmail.com");
    }


    @Test
    public void delete(){
        User user = userRepository.findById(1L).get();
        userRepository.delete(user);

        User optional = userRepository.findByEmail("apigaramian1@gmail.com");

        Assertions.assertThat(user).isNull();
    }

}
