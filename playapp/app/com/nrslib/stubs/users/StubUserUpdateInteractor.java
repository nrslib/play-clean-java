package com.nrslib.stubs.users;

import com.google.inject.Inject;
import com.nrslib.lib.json.objectLoader.JsonsLoader;
import com.nrslib.usecases.user.update.UserUpdateInputData;
import com.nrslib.usecases.user.update.UserUpdateOutputData;
import com.nrslib.usecases.user.update.UserUpdateUseCase;

public class StubUserUpdateInteractor implements UserUpdateUseCase {
    @Inject
    private JsonsLoader jsonsLoader;

    @Override
    public UserUpdateOutputData handle(UserUpdateInputData inputData) {
        return jsonsLoader.generate(UserUpdateOutputData.class);
    }
}
