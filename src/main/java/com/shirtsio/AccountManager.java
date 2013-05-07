package com.shirtsio;


import com.shirtsio.model.Account;
import com.shirtsio.model.AccountResult;

public class AccountManager extends ApiTemplate {

    private String accountUrl = "internal/integration/balance/";

    public String getBalance() {
        return getAccount().getBalance();
    }

    public Account getAccount() {
        return restTemplate.getForObject(buildRequestUrl(accountUrl, null), AccountResult.class)
                           .getAccount();
    }

    public static void main(String[] args) {
        System.out.println(new AccountManager().getBalance());
    }
}
