package com.nrslib.usecases.account.commons;

public class AccountInfo {
    private String id;
    private String name;

    public AccountInfo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private AccountInfo() {}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
