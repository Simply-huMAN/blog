package com.example.blog.controller;

import com.example.blog.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/blogs")
public class BlogContainer {
    @Autowired
    private BlogService blogService;

    @PostMapping
    public void createBlog(@RequestBody BlogDTO blogDTO) {
        try {
            blogService.createBlog(blogDTO);
        } catch (Exception e) {
            log.error("Error creating blog: {}", e.getMessage());
        }
    }
}
