package com.shirtsio.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class OrderStatus {
    private String status;
    @JsonProperty("tracking_numbers")
    private String[] trackingNumbers;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getTrackingNumbers() {
        return trackingNumbers;
    }

    public void setTrackingNumbers(String[] trackingNumbers) {
        this.trackingNumbers = trackingNumbers;
    }
}
