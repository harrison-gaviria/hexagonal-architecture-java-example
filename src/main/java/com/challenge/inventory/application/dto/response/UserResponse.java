package com.challenge.inventory.application.dto.response;

import lombok.Builder;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private String username;
    private String lastname;
    private String firstName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
