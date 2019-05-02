package com.nrslib.usecases.user.getDetail;

import com.nrslib.usecases.core.OutputData;
import com.nrslib.usecases.user.common.UserData;

import java.util.Optional;

public class UserGetDetailOutputData implements OutputData {
    private Optional<UserData> userData;

    public UserGetDetailOutputData(Optional<UserData> userData) {
        this.userData = userData;
    }

    private UserGetDetailOutputData() {
    }

    public Optional<UserData> getUserData() {
        return userData;
    }
}
