package com.example.demo.services.login;



import com.example.demo.Entity.User;
import com.example.demo.repository.login.UserLoginRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserLoginService {
    private final UserLoginRepository userRepository;

    public UserLoginService(UserLoginRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}