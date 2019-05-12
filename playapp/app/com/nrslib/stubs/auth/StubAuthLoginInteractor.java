package com.nrslib.stubs.auth;

import com.google.inject.Inject;
import com.nrslib.lib.json.objectLoader.JsonsLoader;
import com.nrslib.usecases.auth.login.AuthLoginInputData;
import com.nrslib.usecases.auth.login.AuthLoginOutputData;
import com.nrslib.usecases.auth.login.AuthLoginUseCase;

public class StubAuthLoginInteractor implements AuthLoginUseCase {
    @Inject
    private JsonsLoader jsonsLoader;

    @Override
    public AuthLoginOutputData handle(AuthLoginInputData inputData) {
        return jsonsLoader.generate(AuthLoginOutputData.class);
    }
}
