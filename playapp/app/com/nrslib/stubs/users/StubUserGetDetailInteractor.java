package com.nrslib.stubs.users;

import com.google.inject.Inject;
import com.nrslib.lib.json.objectLoader.JsonsLoader;
import com.nrslib.usecases.user.getDetail.UserGetDetailInputData;
import com.nrslib.usecases.user.getDetail.UserGetDetailOutputData;
import com.nrslib.usecases.user.getDetail.UserGetDetailUseCase;

public class StubUserGetDetailInteractor implements UserGetDetailUseCase {
    @Inject
    private JsonsLoader jsonsLoader;

    @Override
    public UserGetDetailOutputData handle(UserGetDetailInputData inputData) {
        return jsonsLoader.generate(UserGetDetailOutputData.class);
    }
}
