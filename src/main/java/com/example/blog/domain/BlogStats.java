package com.example.blog.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class BlogStats {
    @Id
    @Schema(description = "Unique identifier for the blog stats")
    private Long id;

    @Schema(description = "Number of likes for the blog")
    private Integer likes;

    @Schema(description = "Number of dislikes for the blog")
    private Integer dislikes;

    @Schema(description = "Number of shares for the blog")
    private Integer shares;

    @Schema(description = "Number of bookmarks for the blog")
    private Integer bookmarks;

    @Schema(description = "Users who liked the blog")
    private Set<String> likedBy;

    @Schema(description = "Users who disliked the blog")
    private Set<String> dislikedBy;

    @Schema(description = "Users who bookmarked the blog")
    private Set<String> bookmarkedBy;

}
