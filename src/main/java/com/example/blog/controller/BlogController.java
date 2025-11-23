package com.example.blog.controller;

import com.example.blog.dto.BlogDTO;
import com.example.blog.response.ErrorResponse;
import com.example.blog.response.Response;
import com.example.blog.service.BlogService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/getAll")
    public ResponseEntity<Response> getAllBlogs(Pageable pageable) {
        try{
            return new ResponseEntity<>(blogService.getAllBlogs(pageable), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Response> getBlogById(@RequestParam("id") UUID blogId) {
        try {
            return new ResponseEntity<>(blogService.getBlogById(blogId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create-blog")
    public ResponseEntity<Response> createBlog(@Valid @RequestBody BlogDTO requestBody) {
        try{
            return new ResponseEntity<>(blogService.createBlog(requestBody), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/search")
    public ResponseEntity<Response> searchBlogs(@RequestParam(value = "title", required = false) String title,
                                                @RequestParam(value = "author", required = false) String author,
                                                @RequestParam(value = "category", required = false) String category,
                                                @RequestParam(value = "tags", required = false)List<String> tags,
                                                Pageable pageable) {
        try{
            return new ResponseEntity<>(blogService.searchBlogs(title, author, category, tags, pageable), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
