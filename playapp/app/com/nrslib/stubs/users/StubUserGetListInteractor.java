package com.nrslib.stubs.users;

import com.google.inject.Inject;
import com.nrslib.lib.json.objectLoader.JsonsLoader;
import com.nrslib.usecases.user.getList.UserGetListInputData;
import com.nrslib.usecases.user.getList.UserGetListOutputData;
import com.nrslib.usecases.user.getList.UserGetListUseCase;

public class StubUserGetListInteractor implements UserGetListUseCase {
    @Inject
    private JsonsLoader jsonsLoader;

    @Override
    public UserGetListOutputData handle(UserGetListInputData inputData) {
        return jsonsLoader.generate(UserGetListOutputData.class);
    }
}
