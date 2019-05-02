package com.nrslib.usecases.user.getDetail;

import com.nrslib.usecases.core.InputData;

public class UserGetDetailInputData implements InputData<UserGetDetailOutputData> {
    private String userId;

    public UserGetDetailInputData(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
