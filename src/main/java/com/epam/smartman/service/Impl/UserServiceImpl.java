package com.epam.smartman.service.Impl;

import com.epam.smartman.domain.User;
import com.epam.smartman.repository.UserRepository;
import com.epam.smartman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Such user is not present"));
        return user;
    }

    @Transactional
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(User updatedUser, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Such user is not present"));
        user.setSurname(updatedUser.getSurname());
        user.setName(updatedUser.getName());
        user.setMiddleName(updatedUser.getMiddleName());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Such user is not present"));
        userRepository.delete(user);
    }
}
