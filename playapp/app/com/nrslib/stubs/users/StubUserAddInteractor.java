package com.nrslib.stubs.users;

import com.google.inject.Inject;
import com.nrslib.lib.json.objectLoader.JsonsLoader;
import com.nrslib.usecases.user.add.UserAddInputData;
import com.nrslib.usecases.user.add.UserAddOutputData;
import com.nrslib.usecases.user.add.UserAddUseCase;

public class StubUserAddInteractor implements UserAddUseCase {
    @Inject
    private JsonsLoader jsonsLoader;

    @Override
    public UserAddOutputData handle(UserAddInputData inputData) {
        return jsonsLoader.generate(UserAddOutputData.class);
    }
}
