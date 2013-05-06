package com.shirtsio.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Account {
    private String balance;
    @JsonProperty("user_id")
    private long userId;
    private boolean success;
    @JsonProperty("credit_limit")
    private String creditLimit;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
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
}
