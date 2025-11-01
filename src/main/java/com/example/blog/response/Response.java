package com.example.blog.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public abstract class Response {
    @Schema(description = "Metadata of the response")
    private Metadata metadata;

}
