package com.nrslib.stubs.users;

import com.google.inject.Inject;
import com.nrslib.lib.json.objectLoader.JsonsLoader;
import com.nrslib.usecases.user.delete.UserDeleteInputData;
import com.nrslib.usecases.user.delete.UserDeleteOutputData;
import com.nrslib.usecases.user.delete.UserDeleteUseCase;

public class StubUserDeleteInteractor implements UserDeleteUseCase {
    @Inject
    private JsonsLoader jsonsLoader;

    @Override
    public UserDeleteOutputData handle(UserDeleteInputData inputData) {
        return jsonsLoader.generate(UserDeleteOutputData.class);
    }
}
