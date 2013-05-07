package com.shirtsio.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class PaymentResult {
    private boolean success;
    private int transactionId;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @JsonProperty("transaction_id")
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}
