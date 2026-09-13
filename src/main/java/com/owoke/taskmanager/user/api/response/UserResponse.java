package com.owoke.taskmanager.user.api.response;

import java.time.OffsetDateTime;

public record UserResponse(
        Long id,
        String username,
        String email,
        boolean emailVerified,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {}
