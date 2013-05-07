package com.shirtsio.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class AccountResult {

    private Account account;

    @JsonProperty("result")
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
