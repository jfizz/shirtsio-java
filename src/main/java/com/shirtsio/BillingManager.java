package com.shirtsio;

import com.shirtsio.model.Payment;
import com.shirtsio.model.PaymentResponse;

import java.util.Map;

public class BillingManager extends ApiTemplate {

    private String paymentUrl = "payment/";
    private String paymentStatusUrl = "payment_status/";

    public Payment doPayment(Map<String, Object> params) {
        return post(paymentUrl, params, PaymentResponse.class).getResult();
    }

    public Payment updatePaymentStatus(Map<String, Object> params) {
        return post(paymentStatusUrl, params, PaymentResponse.class).getResult();
    }

}
