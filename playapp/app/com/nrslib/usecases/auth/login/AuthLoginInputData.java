package com.nrslib.usecases.auth.login;

import com.nrslib.usecases.core.InputData;

public class AuthLoginInputData implements InputData<AuthLoginOutputData> {
    private final String id;
    private final String password;

    public AuthLoginInputData(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
