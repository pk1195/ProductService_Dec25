package com.example.productservicebydheerajkumar.controller;

import com.example.productservicebydheerajkumar.dto.PaymentRequestDto;
import com.example.productservicebydheerajkumar.service.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    //object of PaymentService is required here
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payments")
    public ResponseEntity<String> createPayment(@RequestBody PaymentRequestDto paymentRequestDto) throws StripeException {
        // Logic to process the payment would go here
        String paymentLink = paymentService.makePayment(paymentRequestDto.getOrderId(), paymentRequestDto.getAmount());

        return new ResponseEntity<>(paymentLink, HttpStatus.OK);

    }

    public ResponseEntity<String> handleStripeEvent(){
        // Logic to handle Stripe webhook events would go here
        return new ResponseEntity<>("Event received", HttpStatus.OK);
    }

}
