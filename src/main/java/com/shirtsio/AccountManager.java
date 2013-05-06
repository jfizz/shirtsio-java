package com.shirtsio;


import com.shirtsio.model.Account;

public class AccountManager extends ApiTemplate {

    private String account_url = "internal/integration/balance/";

    public String getBalance() {
        Account account = this.getObject(account_url, Account.class, null);
        return account.getBalance();
    }

    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();

        System.out.println(accountManager.getBalance());
    }
}
