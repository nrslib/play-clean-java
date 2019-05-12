package com.nrslib.stubs.account;

import com.google.inject.Inject;
import com.nrslib.lib.json.objectLoader.JsonsLoader;
import com.nrslib.usecases.account.getInfo.AccountGetInfoInputData;
import com.nrslib.usecases.account.getInfo.AccountGetInfoOutputData;
import com.nrslib.usecases.account.getInfo.AccountGetInfoUseCase;

public class StubAccountGetInfoInteractor implements AccountGetInfoUseCase {
    @Inject
    private JsonsLoader jsonsLoader;

    @Override
    public AccountGetInfoOutputData handle(AccountGetInfoInputData inputData) {
        return jsonsLoader.generate(AccountGetInfoOutputData.class);
    }
}
