package com.productservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public sealed interface AuthRequest permits AuthRequest.Register, AuthRequest.Login {
    record Register(
            @NotBlank @Email String email,
            @NotBlank @Size(min = 3, max = 50) String username,
            @NotBlank @Size(min = 8) String password
    ) implements AuthRequest {}

    record Login(
            @NotBlank @Email String email,
            @NotBlank String password
    ) implements AuthRequest {}
}
