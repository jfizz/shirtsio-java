package com.shirtsio;


import com.shirtsio.model.Account;
import com.shirtsio.model.AccountResult;

public class AccountManager extends ApiTemplate {

    private String account_url = "internal/integration/balance/";

    public String getBalance() {
        return getAccount().getBalance();
    }

    public Account getAccount() {
        return restTemplate.getForObject(buildRequestUrl(account_url, null), AccountResult.class)
                           .getAccount();
    }

    public static void main(String[] args) {
        System.out.println(new AccountManager().getBalance());
    }
}
