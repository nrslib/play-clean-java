package com.nrslib.usecases.user.getList;

import com.nrslib.usecases.core.OutputData;
import com.nrslib.usecases.user.common.UserData;

import java.util.ArrayList;
import java.util.List;

public class UserGetListOutputData implements OutputData {
    private List<UserData> users;

    public UserGetListOutputData(List<UserData> users) {
        this.users = users;
    }

    private UserGetListOutputData() {
        this.users = new ArrayList<>();
    }

    public List<UserData> getUsers() {
        return users;
    }
}
