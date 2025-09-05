package com.example.blog.domain;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    @Lob
    private String content;
    private String author;
    private BlogCategory category;
    private List<String> tags;
    private BlogStats stats;

    // User count fields
    @ElementCollection
    private Set<String> likedBy;
    @ElementCollection
    private Set<String> dislikedBy;
    @ElementCollection
    private Set<String> bookmarkedBy;

    // Time fields, all times are stored in UTC
    private Instant createdAt;
    private Instant updatedAt;
}
