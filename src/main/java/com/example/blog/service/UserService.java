package com.example.blog.service;

import com.example.blog.domain.User;
import com.example.blog.repository.UserRepository;
import com.example.blog.response.AcknowledgmentResponse;
import com.example.blog.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Response getUserDetails(String username, String email) {
        User user = null;

        if(username!=null) {
            user = userRepository.findByUsername(username);
        }
        else if(email!=null) {
            user  = userRepository.findByEmail(email);
        }
        return new AcknowledgmentResponse<>("user details fetched successfully", user, null);
    }

    public Response createUser(User user) {
        userRepository.save(user);
        return new AcknowledgmentResponse<>("user created successfully", user, null);
    }

}
