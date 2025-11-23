package com.example.blog.repository;

import com.example.blog.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogRepository extends JpaRepository<Blog, UUID> {
}
