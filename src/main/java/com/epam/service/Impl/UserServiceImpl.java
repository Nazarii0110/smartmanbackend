package com.epam.service.Impl;

import com.epam.domain.User;
import com.epam.repository.UserRepository;
import com.epam.service.UserService;
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
        User user = userRepository.findById(userId).get();
        if (user == null) throw new NoSuchElementException();
        return user;
    }

    @Transactional
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(User updatedUser, Long userId) {
        User user = userRepository.findById(userId).get();
        if (user == null) throw new NoSuchElementException();
        user.setSurname(updatedUser.getSurname());
        user.setName(updatedUser.getName());
        user.setMiddleName(updatedUser.getMiddleName());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).get();//2.0.0.M7
        if (user == null) throw new NoSuchElementException();
        userRepository.delete(user);
    }
}
