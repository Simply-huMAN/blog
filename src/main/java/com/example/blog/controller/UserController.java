package com.example.blog.controller;

import com.example.blog.response.Response;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public ResponseEntity<Response> getUserDetails(@RequestParam(value = "username", required = false) String username,
                                                   @RequestParam(value = "email", required = false) String email) {
        return userService.getUserDetails(username, email);
    }
}
