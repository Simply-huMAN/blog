package com.example.blog.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(description = "Unique identifier for the blog")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;

    @Schema(description = "Blog title")
    private String title;

    @Lob
    @Schema(description = "Blog content")
    private String content;

    @Schema(description = "Author of the blog")
    private String author;

    @Schema(description = "Blog category")
    private BlogCategory category;

    @Schema(description = "Tags associated with the blog")
    private List<String> tags;

//    @Schema(description = "Statistics related to the blog")
//    private BlogStats stats;


    // User count fields
    @ElementCollection
    @Schema(description = "Set of users who liked the blog")
    private Set<String> likedBy;

    @ElementCollection
    @Schema(description = "Set of users who disliked the blog")
    private Set<String> dislikedBy;

    @ElementCollection
    @Schema(description = "Set of users who bookmarked the blog")
    private Set<String> bookmarkedBy;


    // Time fields, all times are stored in UTC
    @Schema(description = "Timestamp of blog creation")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant createdAt;

    @Schema(description = "Timestamp of last blog update")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant updatedAt;

}
