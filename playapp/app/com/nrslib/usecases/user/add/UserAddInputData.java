package com.nrslib.usecases.user.add;

import com.nrslib.usecases.core.InputData;

public class UserAddInputData implements InputData<UserAddOutputData> {
    private final String userName;

    public UserAddInputData(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
