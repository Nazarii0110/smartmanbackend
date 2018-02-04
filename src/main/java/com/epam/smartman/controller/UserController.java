package com.epam.smartman.controller;

import com.epam.smartman.controller.DTO.UserDTO;
import com.epam.smartman.domain.User;
import com.epam.smartman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/api/user")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        Link link = linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel();

        List<UserDTO> userDTOList = new ArrayList<>();
        for (User entity : userList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
            UserDTO dto = new UserDTO(entity, selfLink);
            userDTOList.add(dto);
        }

        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/api/user/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long userId) {
        User user = userService.getUser(userId);
        Link link = linkTo(methodOn(UserController.class).getUser(userId)).withSelfRel();

        UserDTO userDTO = new UserDTO(user, link);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/api/user")
    public ResponseEntity<UserDTO> addUser(@RequestBody User newUser) {
        userService.createUser(newUser);
        Link link = linkTo(methodOn(UserController.class).getUser(newUser.getId())).withSelfRel();

        UserDTO userDTO = new UserDTO(newUser, link);

        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/api/user/{userId}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody User updatedUser, @PathVariable Long userId) {
        userService.updateUser(updatedUser, userId);
        User user = userService.getUser(userId);
        Link link = linkTo(methodOn(UserController.class).getUser(userId)).withSelfRel();

        UserDTO userDTO = new UserDTO(user, link);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/user/{userId}")
    public ResponseEntity deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
