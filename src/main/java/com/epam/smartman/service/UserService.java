package com.epam.smartman.service;

import com.epam.smartman.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUser(Long userId);

    void createUser(User user);

    void updateUser(User updatedUser, Long userId);

    void deleteUser(Long userId);
}
