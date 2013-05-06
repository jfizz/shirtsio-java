package com.shirtsio.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Authentication {
    private String apiKey;

    @JsonProperty("api_key")
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
