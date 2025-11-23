package com.example.blog.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.domain.Pageable;

@Data
public class AcknowledgmentResponse<T> extends Response{
    @Schema(description = "Data of the acknowledgment response")
    private T data;

    public AcknowledgmentResponse() {
        super();
        setMetadata(new Metadata(new java.sql.Timestamp(System.currentTimeMillis()), 200, "Success", null));
    }

    public AcknowledgmentResponse(String message, T data, Pageable pageable) {
        this();
        getMetadata().setMessage(message);
        getMetadata().setPageable(pageable);
        this.data = data;
    }
}
