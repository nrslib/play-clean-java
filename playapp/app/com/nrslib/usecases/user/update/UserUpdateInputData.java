package com.nrslib.usecases.user.update;

import com.nrslib.usecases.core.InputData;

public class UserUpdateInputData implements InputData<UserUpdateOutputData> {
    private final String id;
    private final String name;

    private UserUpdateInputData(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static class Builder {
        private final String id;
        private String name;

        public Builder(String id) {
            this.id = id;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public UserUpdateInputData build(){
            return new UserUpdateInputData(id, name);
        }
    }
}
