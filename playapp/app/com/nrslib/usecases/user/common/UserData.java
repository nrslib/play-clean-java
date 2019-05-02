package com.nrslib.usecases.user.common;

public class UserData {
    private String id;
    private String name;

    public UserData(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private UserData(){
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
