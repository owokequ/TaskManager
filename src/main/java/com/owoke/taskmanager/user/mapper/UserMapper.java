package com.owoke.taskmanager.user.mapper;

import com.owoke.taskmanager.user.api.response.UserResponse;
import com.owoke.taskmanager.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.isEmailVerified(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
