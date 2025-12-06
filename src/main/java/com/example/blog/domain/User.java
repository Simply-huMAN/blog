package com.example.blog.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(unique = true)
    @Schema(description = "Username of the user")
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Schema(description = "Password of the user")
    private String password;

    @Schema(description = "Firstname of the user")
    private String firstname;

    @Schema(description = "Lastname of the user")
    private String lastname;

    @Schema(description = "Description of the user")
    private String description;

    @ElementCollection
    @Schema(description = "Blogs created by the user")
    private Set<String> blogs;
}
