package com.shirtsio;


import com.shirtsio.model.Authentication;
import com.shirtsio.model.AuthenticationResult;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager extends ApiTemplate {

    private String authenticationUrl = "internal/integration/auth/";

    public Authentication authenticate(String username, String password) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);
        params.put("password", password);

        return restTemplate.getForObject(
                buildRequestUrl(authenticationUrl, params), AuthenticationResult.class
        ).getAuthentication();
    }

    public static void main(String[] args) {
        System.out.println(new AuthenticationManager().authenticate("deantest", "Pa$$w0rd").getApiKey());
    }
}
