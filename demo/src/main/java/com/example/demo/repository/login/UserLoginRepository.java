package com.example.demo.repository.login;

import com.example.demo.Entity.User;
//import com.tericcabrel.authapi.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserLoginRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);

}
