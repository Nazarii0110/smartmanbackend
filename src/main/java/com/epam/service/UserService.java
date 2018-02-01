package com.epam.service;

import com.epam.domain.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUser(Long userId);

    public void createUser(User user);

    public void updateUser(User updatedUser, Long userId);

    public void deleteUser(Long userId);
}
