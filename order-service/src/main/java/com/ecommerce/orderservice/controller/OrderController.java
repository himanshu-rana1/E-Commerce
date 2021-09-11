package com.ecommerce.orderservice.controller;

import com.ecommerce.orderservice.entity.OrderObject;
import com.ecommerce.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/makeOrder")
    public String makeOrder(@RequestBody OrderObject orderObject){

        /**
         Do inventory check
         **/

        //Call Payment service API for payment processing if Product available
        OrderObject isOrder = orderService.saveOrder(orderObject);
        if(isOrder != null)
            return "Order is made succesfully";
        else
            return "Order can't be made payment was unsuccesfull";

        //if order successfull sent mail to client

    }

    @GetMapping("/getOrder")
    public OrderObject getOrder(Long id){

        return orderService.getOrder(id);
    }
}
