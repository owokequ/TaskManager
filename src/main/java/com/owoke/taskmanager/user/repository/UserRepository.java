package com.owoke.taskmanager.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.owoke.taskmanager.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailAndIdNot(String email, Long id);

    boolean existsByUsernameAndIdNot(String username, Long id);
}
