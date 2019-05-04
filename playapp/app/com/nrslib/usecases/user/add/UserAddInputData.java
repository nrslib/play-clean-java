package com.nrslib.usecases.user.add;

import com.nrslib.domain.model.user.UserRole;
import com.nrslib.usecases.core.InputData;

public class UserAddInputData implements InputData<UserAddOutputData> {
    private final String userName;
    private final UserRole role;

    public UserAddInputData(String userName, UserRole role) {
        this.userName = userName;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public UserRole getRole() {
        return role;
    }
}
