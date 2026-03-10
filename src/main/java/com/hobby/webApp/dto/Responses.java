package com.hobby.webApp.dto;

import com.hobby.webApp.entity.User;

import java.time.Instant;
import java.util.UUID;

public class Responses {
    public record UserResponse(UUID id, String email, String username, String role, Instant createdAt) {
        public static UserResponse from(User user) {
            return new UserResponse(user.getId(), user.getEmail(), user.getUsername(), user.getRole().name(),
                    user.getCreatedAt());
        }
    }
}
