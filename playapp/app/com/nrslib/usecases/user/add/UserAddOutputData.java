package com.nrslib.usecases.user.add;

import com.nrslib.usecases.core.OutputData;

public class UserAddOutputData implements OutputData {
    private String userId;

    public UserAddOutputData(String userId) {
        this.userId = userId;
    }

    private UserAddOutputData() {}

    public String getUserId() {
        return userId;
    }
}
