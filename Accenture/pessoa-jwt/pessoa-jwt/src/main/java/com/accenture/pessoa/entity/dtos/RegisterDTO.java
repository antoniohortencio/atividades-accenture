package com.accenture.pessoa.entity.dtos;

import com.accenture.pessoa.entity.enums.UserRoles;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
        @NotBlank String login,
        @NotBlank String password,
        @NotNull  UserRoles role
) {}
