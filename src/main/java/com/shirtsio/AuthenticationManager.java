package com.shirtsio;


import com.shirtsio.model.Authentication;
import com.shirtsio.model.AuthenticationResponse;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager extends ApiTemplate {

    private String authenticationUrl = "internal/integration/auth/";

    public Authentication authenticate(String username, String password) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);
        params.put("password", password);

        return get(authenticationUrl, AuthenticationResponse.class, params)
                    .getResult();
    }

    public static void main(String[] args) {
        System.out.println(new AuthenticationManager().authenticate("deantest", "Pa$$w0rd").getApiKey());
    }
}
