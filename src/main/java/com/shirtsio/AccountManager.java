package com.shirtsio;


import com.shirtsio.model.Account;
import com.shirtsio.model.AccountResponse;
import com.shirtsio.model.RegisterUser;
import com.shirtsio.model.RegisterUserResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class AccountManager extends ApiTemplate {

    private String accountUrl = "internal/integration/balance/";
    private String registerUrl = "internal/user/register/";
    private String updateUrl = "internal/user/update/";

    public String getBalance() {
        return getAccount().getBalance();
    }

    public Account getAccount() {
        return get(accountUrl, AccountResponse.class, null).getResult();
    }

    public String getCreditLimit() {
        return getAccount().getCreditLimit();
    }

    public RegisterUser registerUser(MultiValueMap<String, Object> params) {
        return post(registerUrl, params, RegisterUserResponse.class).getResult();
    }

    public boolean updateUser(MultiValueMap<String, Object> params) {
        return post(updateUrl, params, RegisterUserResponse.class).getResult().isSuccess();
    }

    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();
        System.out.println(accountManager.getBalance());
        System.out.println(accountManager.getCreditLimit());

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("user[username]", "roland");
        params.add("user[password]", "test");
        params.add("user[email]", "roland@gmail.com");
        System.out.println(accountManager.registerUser(params).getApiKey());
    }
}
