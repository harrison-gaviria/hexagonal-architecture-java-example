package com.challenge.inventory.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    @NotNull(message = "Username cannot be null.")
    private String username;

    @NotNull(message = "Last name cannot be null.")
    private String lastName;

    @NotNull(message = "First name cannot be null.")
    private String firstName;

    @NotNull(message = "Email address cannot be null.")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email format.")
    private String email;
}