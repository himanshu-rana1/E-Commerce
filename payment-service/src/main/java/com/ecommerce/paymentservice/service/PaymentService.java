package com.ecommerce.paymentservice.service;

import com.ecommerce.paymentservice.entity.Payment;
import com.ecommerce.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public Payment savePayment(Long id, Double price){

        Payment payment = new Payment();

        //Should call the API for payment transactions like GooglePay
        payment.setPaymentStatus(new Random().nextBoolean()?"Success" : "Not Successful");
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setOrderId(id);
        payment.setPrice(price);
        paymentRepository.save(payment);

        if(payment.getPaymentStatus().equals("Success"))
            return payment;
        else
            return null;
    }

    public List<Payment> getAll(){

        return paymentRepository.findAll();
    }
}
