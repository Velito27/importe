package com.example.Imp.Service;

import com.example.Imp.Entity.UserEntity;
import com.example.Imp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

}