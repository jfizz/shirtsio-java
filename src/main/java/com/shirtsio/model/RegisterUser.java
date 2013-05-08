package com.shirtsio.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class RegisterUser {
    private String username;
    private boolean success;
    @JsonProperty("user_id")
    private long userId;
    @JsonProperty("api_key")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
