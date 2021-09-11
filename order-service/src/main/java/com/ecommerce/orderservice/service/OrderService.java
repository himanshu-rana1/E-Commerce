package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.entity.OrderObject;
import com.ecommerce.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    RestTemplate restTemplate;

    public OrderObject saveOrder(OrderObject orderObject){

        OrderObject object = orderRepository.save(orderObject);
        String result = restTemplate.getForObject("http://PAYMENT-SERVICE/payment/makePayment/" + object.getId() +"/"+ object.getPrice(), String.class);

        if(result.equals("Successfull"))
            return object;
        else
            return null;
    }

    public OrderObject getOrder(Long id){

        return orderRepository.findById(id).get();
    }
}
