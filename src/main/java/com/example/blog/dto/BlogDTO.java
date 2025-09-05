package com.example.blog.dto;

import lombok.Data;

@Data
public class BlogDTO {
    private Long id;
    private String title;
    private String content;
    private String authorName;
    private String createdAt;
    private String updatedAt;
    private long likesCount;
    private long dislikesCount;
    private long bookmarksCount;
    private long sharesCount;
    private boolean isLikedByUser;
    private boolean isDislikedByUser;
    private boolean isBookmarkedByUser;
}
