package com.epam.controller.DTO;


import com.epam.domain.User;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class UserDTO extends ResourceSupport {
    User user;

    public UserDTO(User user, Link selfLink) {
        this.user = user;
        add(selfLink);
    }

    public Long getUserId() {
        return user.getId();
    }

    public String getSurname() {
        return user.getSurname();
    }

    public String getName() {
        return user.getName();
    }

    public String getMiddleName() {
        return user.getMiddleName();
    }
}