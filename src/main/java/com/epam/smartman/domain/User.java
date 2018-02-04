package com.epam.smartman.domain;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "surname", nullable = false, length = 45)
    private String surname;
    @Column(name = "name", nullable = false, length = 45)
    private String username;
    @Column(name = "middle_name", nullable = true, length = 45)
    private String middleName;
    @Column(name = "password" , nullable = false, length = 45)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String midleName) {
        this.middleName = midleName;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (middleName != null ? !middleName.equals(user.middleName) : user.middleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        return result;
    }
}
