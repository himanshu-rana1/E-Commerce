package com.ecommerce.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/catalogServiceFallBack")
    public String catalogServiceFallbackMethod(){

        return "Catalog Service isn't available right now. Please try again later";
    }

    @GetMapping("/cartServiceFallBack")
    public String cartServiceFallbackMethod(){

        return "Cart Service isn't available right now. Please try again later";
    }

    @GetMapping("/orderServiceFallBack")
    public String orderServiceFallbackMethod(){

        return "Order Service isn't available right now. Please try again later";
    }

    @GetMapping("/paymentServiceFallBack")
    public String paymentServiceFallbackMethod(){

        return "Payment Service isn't available right now. Please try again later";
    }
}
