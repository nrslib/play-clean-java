package com.nrslib.usecases.account.getInfo;

import com.nrslib.usecases.account.commons.AccountInfo;
import com.nrslib.usecases.core.OutputData;

public class AccountGetInfoOutputData implements OutputData {
    private AccountInfo accountInfo;

    public AccountGetInfoOutputData(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    private AccountGetInfoOutputData() {}

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }
}
