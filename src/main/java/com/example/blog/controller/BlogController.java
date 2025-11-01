package com.example.blog.controller;

import com.example.blog.dto.BlogDTO;
import com.example.blog.response.ErrorResponse;
import com.example.blog.response.Response;
import com.example.blog.service.BlogService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public ResponseEntity<Response> getAllBlogs() {
        try{
            return new ResponseEntity<>(blogService.getAllBlogs(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Response> createBlog(@Valid @RequestBody BlogDTO requestBody) {
        try{
            return new ResponseEntity<>(blogService.createBlog(requestBody), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
