package com.example.blog.controller;

import com.example.blog.domain.User;
import com.example.blog.response.Response;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public ResponseEntity<Response> getUserDetails(@RequestParam(value = "username", required = false) String username,
                                                   @RequestParam(value = "email", required = false) String email) {
        return ResponseEntity.ok(userService.getUserDetails(username, email));
    }

    public ResponseEntity<Response> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);

    }
}
