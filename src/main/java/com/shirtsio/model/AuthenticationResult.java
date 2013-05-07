package com.shirtsio.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class AuthenticationResult {
    private Authentication authentication;

    @JsonProperty("result")
    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }
}
