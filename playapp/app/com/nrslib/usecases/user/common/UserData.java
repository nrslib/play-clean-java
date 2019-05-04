package com.nrslib.usecases.user.common;

import com.nrslib.domain.model.user.UserRole;

public class UserData {
    private String id;
    private String name;
    private UserRole role;

    public UserData(String id, String name, UserRole role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    private UserData(){
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserRole getRole() { return role; }
}
