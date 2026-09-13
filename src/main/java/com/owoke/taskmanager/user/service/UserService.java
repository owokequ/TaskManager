package com.owoke.taskmanager.user.service;

import com.owoke.taskmanager.user.api.request.UpdateUserRequest;
import com.owoke.taskmanager.user.api.response.UserResponse;

public interface UserService {

    UserResponse getUserById(Long userId);

    UserResponse updateUser(Long userId, UpdateUserRequest request);

    void deleteUser(Long userId);
}
