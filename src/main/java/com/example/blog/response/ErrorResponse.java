package com.example.blog.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ErrorResponse extends Response{
    @Schema(description = "Details of the error")
    private String errorDetails;

    public ErrorResponse() {
        setMetadata(new Metadata(new java.sql.Timestamp(System.currentTimeMillis()), 500,
                "An error occurred while processing the request."));
    }

    public ErrorResponse(String errorDetails) {
        this();
        this.errorDetails = errorDetails;
    }
}
