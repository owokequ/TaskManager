package com.owoke.taskmanager.user.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.owoke.taskmanager.user.api.request.UpdateUserRequest;
import com.owoke.taskmanager.user.api.response.UserResponse;
import com.owoke.taskmanager.user.domain.User;
import com.owoke.taskmanager.user.exception.UserNotFoundException;
import com.owoke.taskmanager.user.mapper.UserMapper;
import com.owoke.taskmanager.user.repository.UserRepository;
import com.owoke.taskmanager.user.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        log.info("Deleting user: id={}", userId);
        userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        userRepository.deleteById(userId);
        log.info("User deleted: id={}", userId);
    }

    @Override
    public UserResponse getUserById(Long userId) {
        log.debug("Fetching user: id={}", userId);
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        return userMapper.toResponse(user);
    }

    @Override
    @Transactional
    public UserResponse updateUser(Long userId, UpdateUserRequest request) {
        log.info("Updating user profile: id={}", userId);
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        user.setEmail(request.email());
        user.setUsername(request.username());

        userRepository.flush();
        UserResponse response = userMapper.toResponse(user);
        log.info("User profile updated: id={}", userId);
        return response;
    }

}
