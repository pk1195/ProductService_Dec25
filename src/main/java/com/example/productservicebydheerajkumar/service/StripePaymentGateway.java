package com.example.productservicebydheerajkumar.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentGateway implements PaymentService{

    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    @Override
    public String makePayment(String orderId, Long amount) throws StripeException {

        //1.crate PriceCreateParams object

        //api key is available in stripe dashboard
      //  Stripe.apiKey = stripeSecretKey;


        PriceCreateParams params =
                PriceCreateParams.builder()
                        .setCurrency("INR")
                        .setUnitAmount(amount*100)
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName("Order #" +orderId).build()
                        )
                        .build();

        Price price = Price.create(params);

        // 2. create Payment link

 //       Stripe.apiKey = "";

        PaymentLinkCreateParams linkparams =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .setAfterCompletion(
                                PaymentLinkCreateParams.AfterCompletion.builder()
                                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                        .setRedirect(
                                                PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                        .setUrl("https://files-editor.com/")
                                                        .build()
                                        )
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(linkparams);

        return paymentLink.getUrl();
    }
}
