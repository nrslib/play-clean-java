package com.nrslib.domain.application.account;

import com.google.inject.Inject;
import com.nrslib.domain.context.UserContext;
import com.nrslib.usecases.account.commons.AccountInfo;
import com.nrslib.usecases.account.getInfo.AccountGetInfoInputData;
import com.nrslib.usecases.account.getInfo.AccountGetInfoOutputData;
import com.nrslib.usecases.account.getInfo.AccountGetInfoUseCase;

public class AccountGetInfoInteractor implements AccountGetInfoUseCase {
    @Inject
    private UserContext userContext;

    @Override
    public AccountGetInfoOutputData handle(AccountGetInfoInputData inputData) {
        String id = userContext.getId();

        // get data from user id
        AccountInfo accountInfo = new AccountInfo(id, "mock-user-name");

        return new AccountGetInfoOutputData(accountInfo);
    }
}
