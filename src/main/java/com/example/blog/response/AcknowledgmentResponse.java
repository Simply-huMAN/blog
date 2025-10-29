package com.example.blog.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AcknowledgmentResponse<T> extends Response{
    @Schema(description = "Data of the acknowledgment response")
    private T data;

    public AcknowledgmentResponse() {
        setTimestamp(new java.sql.Timestamp(System.currentTimeMillis()));
        setStatus(200);
    }

    public AcknowledgmentResponse(String message, T data) {
        this();
        setMessage(message);
        this.data = data;
    }
}
