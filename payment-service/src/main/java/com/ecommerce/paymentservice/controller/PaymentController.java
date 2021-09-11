package com.ecommerce.paymentservice.controller;

import com.ecommerce.paymentservice.entity.Payment;
import com.ecommerce.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/makePayment/{id}/{price}")
    public String makePayment(@PathVariable Long id, @PathVariable Double price){

        Payment isPayment = paymentService.savePayment(id, price);

        if(isPayment != null)
            return "Successfull";
        else
            return "Unsuccessfull";
    }

    @GetMapping("/getAll")
    public List<Payment> getPayment(){

        return paymentService.getAll();
    }
}
