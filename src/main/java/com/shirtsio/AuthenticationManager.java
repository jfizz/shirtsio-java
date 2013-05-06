package com.shirtsio;


import com.shirtsio.model.Authentication;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {

    private String authentication_url = "internal/integration/auth/";
    private ApiTemplate apiTemplate = new ApiTemplate();

    public Authentication authenticate(String username, String password) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("password", password);
        return apiTemplate.getObject(authentication_url, Authentication.class, params);
    }


    public static void main(String[] args) {
        System.out.println(new AuthenticationManager().authenticate("deantest", "Pa$$w0rd"));
    }
}
