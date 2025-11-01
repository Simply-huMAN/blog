package com.example.blog.service;

import com.example.blog.domain.Blog;
import com.example.blog.dto.BlogDTO;
import com.example.blog.repository.BlogRepository;
import com.example.blog.response.AcknowledgmentResponse;
import com.example.blog.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public Response getAllBlogs() {
        try{
            return new AcknowledgmentResponse<>("Blogs fetched successfully", blogRepository.findAll());
        } catch (Exception e) {
            log.error("Error in getAllBlogs: ", e);
            throw e;
        }
    }

    public Response createBlog(BlogDTO blog) {
        try{
            blogRepository.save(parseBlogDTO(blog));
            return new AcknowledgmentResponse<>("Blog created successfully", blog);
        } catch (Exception e) {
            log.error("Error in createBlog: ", e);
            throw e;
        }
    }

    public String getBlogById(Long id) {
        return "Blog content for ID: " + id;
    }

    private Blog parseBlogDTO(BlogDTO blogDTO) {
        Blog blog = new Blog();
        blog.setTitle(blogDTO.getTitle());
        blog.setContent(blogDTO.getContent());
        blog.setAuthor(blogDTO.getAuthor());
        blog.setCategory(blogDTO.getCategory());
        blog.setTags(blogDTO.getTags());
        blog.setCreatedAt(Instant.now());
        return blog;
    }

}
