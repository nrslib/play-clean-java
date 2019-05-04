package com.nrslib.domain.model.user;

public class User {
    private UserId id;
    private UserName name;
    private UserRole role;

    public User(UserId id, UserName name, UserRole role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public UserId getId() {
        return id;
    }

    public UserName getName() {
        return name;
    }

    public UserRole getRole() { return role; }

    public void changeName(UserName name) {
        this.name = name;
    }
}
