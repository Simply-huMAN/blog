package com.example.blog.service;

import com.example.blog.domain.User;
import com.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String getUserDetails(String username, String email) {
        User user = null;

        if(username!=null) {
            user = userRepository.findByUsername(username);
        }
        else if(email!=null) {
            user  = userRepository.findByEmail(email);
        }
        return "User details";
    }

    public String createUser() {
        userRepository.save(null);
        return "User created";
    }

}
