package com.example.paymentservice.services;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentGateway paymentGateway;
    private final PaymentGatewaySelector paymentGatewaySelector;

    public PaymentServiceImpl(PaymentGateway paymentGateway, PaymentGatewaySelector paymentGatewaySelector) {
        this.paymentGateway = paymentGateway;
        this.paymentGatewaySelector = paymentGatewaySelector;
    }

    @Override
    public String initiatePayment() {
        return paymentGatewaySelector.get().generatePaymentLink();
    }
}
