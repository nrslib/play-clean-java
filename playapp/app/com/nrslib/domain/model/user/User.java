package com.nrslib.domain.model.user;

public class User {
    private UserId id;
    private UserName name;

    public User(UserId id, UserName name) {
        this.id = id;
        this.name = name;
    }

    public UserId getId() {
        return id;
    }

    public UserName getName() {
        return name;
    }

    public void changeName(UserName name) {
        this.name = name;
    }
}
