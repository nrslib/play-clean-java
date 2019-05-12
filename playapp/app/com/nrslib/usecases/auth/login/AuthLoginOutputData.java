package com.nrslib.usecases.auth.login;

import com.nrslib.usecases.account.commons.AccountInfo;
import com.nrslib.usecases.core.OutputData;

public class AuthLoginOutputData implements OutputData {
    private boolean success;
    private AccountInfo accountInfo;

    public AuthLoginOutputData(boolean success, AccountInfo accountInfo) {
        this.success = success;
        this.accountInfo = accountInfo;
    }

    private AuthLoginOutputData() {}

    public boolean isSuccess() {
        return success;
    }

    public AccountInfo getAccountInfo() { return accountInfo; }
}
