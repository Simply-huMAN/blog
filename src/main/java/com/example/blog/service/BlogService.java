package com.example.blog.service;

import com.example.blog.domain.Blog;
import com.example.blog.dto.BlogDTO;
import com.example.blog.repository.BlogRepository;
import com.example.blog.response.AcknowledgmentResponse;
import com.example.blog.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Response getAllBlogs(Pageable pageable) {
        try{
            return new AcknowledgmentResponse<>("Blogs fetched successfully", blogRepository.findAll(), pageable);
        } catch (Exception e) {
            log.error("Error in getAllBlogs: ", e);
            throw e;
        }
    }

    public Response createBlog(BlogDTO blog) {
        try{
            Blog savedBlog = blogRepository.save(parseBlogDTO(blog));
            return new AcknowledgmentResponse<>("Blog created successfully", savedBlog, null);
        } catch (Exception e) {
            log.error("Error in createBlog: ", e);
            throw e;
        }
    }

    public Response updateBlog(UUID blogId, BlogDTO blog) {
        try {
            Optional<Blog> existingBlog = blogRepository.findById(blogId);
            if(existingBlog.isPresent()){
                existingBlog.get().setTitle(blog.getTitle());
                existingBlog.get().setContent(blog.getContent());
                existingBlog.get().setAuthor(blog.getAuthor());
                existingBlog.get().setCategory(blog.getCategory());
                existingBlog.get().setTags(blog.getTags());
                existingBlog.get().setUpdatedAt(Instant.now());
                blogRepository.save(existingBlog.get());
                return new AcknowledgmentResponse<>("Blog updated successfully", blog, null);
            }
            return new AcknowledgmentResponse<>("Blog not found", null, null);
        } catch (Exception e) {
            log.error("Error in updateBlog: ", e);
            throw e;
        }
    }

    public Response getBlogById(UUID id) {
        try{
            log.info("Fetching blog with id: {}", id);
            Optional<Blog> blog = blogRepository.findById(id);
            return new AcknowledgmentResponse<>("Blog fetched successfully", blog, null);
        } catch (Exception e) {
            log.error("Error in getBlogById: ", e);
            throw e;
        }
    }

    public Response searchBlogs(String title, String author, String category, List<String> tags, Pageable pageable) {
        try{
            log.info("Searching blogs with criteria: {}, {}, {}, {}", title, author, category, tags);
            int searchResultsCount = 0;
            Set<Blog> searchResults = new HashSet<>();

            if(title!=null && !title.isEmpty()) searchResults.addAll(searchBlogByTitle(title));
            if(author!=null && !author.isEmpty()) searchResults.addAll(searchBlogByAuthor(author));
            if(category!=null && !category.isEmpty()) searchResults.addAll(searchBlogByCategory(category));
            if(tags!=null && !tags.isEmpty()) searchResults.addAll(searchBlogByTags(tags));
            searchResultsCount = searchResults.size();

            return new AcknowledgmentResponse<>(searchResultsCount + " blogs match search criteria", searchResults, pageable);
        } catch (Exception e) {
            log.error("Error in searchBlogs: ", e);
            throw e;
        }
    }

    private Set<Blog> searchBlogByTitle(String title) {
        return blogRepository
                .findAll()
                .stream()
                .filter(blog -> blog.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toSet());
    }

    private Set<Blog> searchBlogByAuthor(String author) {
        return blogRepository
                .findAll()
                .stream()
                .filter(blog -> blog.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toSet());
    }

    private Set<Blog> searchBlogByCategory(String category) {
        return blogRepository
                .findAll()
                .stream()
                .filter(blog -> blog.getCategory().toString().equalsIgnoreCase(category))
                .collect(Collectors.toSet());
    }

    private Set<Blog> searchBlogByTags(List<String> tags) {
        return blogRepository
                .findAll()
                .stream()
                .filter(blog -> blog.getTags().stream().anyMatch(tag -> tags.contains(tag)))
                .collect(Collectors.toSet());
    }

    private Blog parseBlogDTO(BlogDTO blogDTO) {
        Blog blog = new Blog();
        blog.setTitle(blogDTO.getTitle());
        blog.setContent(blogDTO.getContent());
        blog.setAuthor(blogDTO.getAuthor());
        blog.setCoverImageUrl(blogDTO.getCoverImageUrl());
        blog.setCategory(blogDTO.getCategory());
        blog.setTags(blogDTO.getTags());
        blog.setCreatedAt(Instant.now());
        return blog;
    }

}
