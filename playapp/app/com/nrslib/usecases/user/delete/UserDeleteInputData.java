package com.nrslib.usecases.user.delete;

import com.nrslib.usecases.core.InputData;

public class UserDeleteInputData implements InputData<UserDeleteOutputData> {
    private final String id;

    public UserDeleteInputData(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
