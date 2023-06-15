package org.example.entities;

import org.example.enums.Role;

public class User {
    private String name;
    private String bookRequest;
    private Role role;

    public User() {
    }

    public User(String name, String bookRequest, Role role) {
        this.name = name;
        this.bookRequest = bookRequest;
        this.role = role;
    }

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookRequest() {
        return bookRequest;
    }

    public void setBookRequest(String bookRequest) {
        this.bookRequest = bookRequest;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", bookRequest='" + bookRequest + '\'' +
                ", role=" + role +
                '}';
    }
}
