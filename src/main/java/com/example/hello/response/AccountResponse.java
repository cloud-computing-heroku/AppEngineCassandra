package com.example.hello.response;

import java.util.List;
import java.util.UUID;

public class AccountResponse {
    private List<?> accountList;

    public AccountResponse() {
    }

    public List<?> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<?> accountList) {
        this.accountList = accountList;
    }
}
