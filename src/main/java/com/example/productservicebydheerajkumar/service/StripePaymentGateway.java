package com.example.productservicebydheerajkumar.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentGateway implements PaymentService{

    @Override
    public String makePayment(String orderId, Long amount) throws StripeException {

        //1.crate PriceCreateParams object

        Stripe.apiKey = "sk_test_51Slo0e1dqOSUkysq8v85S3TJk6PKYNQuZQeiXphXRTWnck39PgZ1T0ymUJDC9XLcHMaek87eJRhr4lBVPMveRVtP0076P9tkSM";

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

        Stripe.apiKey = "sk_test_51Slo0e1dqOSUkysq8v85S3TJk6PKYNQuZQeiXphXRTWnck39PgZ1T0ymUJDC9XLcHMaek87eJRhr4lBVPMveRVtP0076P9tkSM";

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
