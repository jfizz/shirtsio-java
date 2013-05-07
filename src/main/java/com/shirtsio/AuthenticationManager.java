package com.shirtsio;


import com.shirtsio.model.Authentication;
import com.shirtsio.model.AuthenticationResult;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager extends ApiTemplate {

    private String authentication_url = "internal/integration/auth/";

    public Authentication authenticate(String username, String password) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("password", password);

        return restTemplate.getForObject(
                buildRequestUrl(authentication_url, params), AuthenticationResult.class
        ).getAuthentication();
    }

    public static void main(String[] args) {
        System.out.println(new AuthenticationManager().authenticate("deantest", "Pa$$w0rd").getApiKey());
    }
}
