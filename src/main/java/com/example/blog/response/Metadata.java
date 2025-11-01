package com.example.blog.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class Metadata {
    @Schema(description = "Timestamp of the response")
    private Timestamp timestamp;

    @Schema(description = "Status of the response")
    private Integer status;

    @Schema(description = "Message of the response")
    private String message;
}
