package com.nrslib.domain.application.auth;

import com.nrslib.usecases.account.commons.AccountInfo;
import com.nrslib.usecases.auth.login.AuthLoginInputData;
import com.nrslib.usecases.auth.login.AuthLoginOutputData;
import com.nrslib.usecases.auth.login.AuthLoginUseCase;

public class AuthLoginInteractor implements AuthLoginUseCase {
    @Override
    public AuthLoginOutputData handle(AuthLoginInputData inputData) {
        return new AuthLoginOutputData(true,  new AccountInfo("mock-test-id", "mock-test-user"));
    }
}
