package com.ecommerce.cartservice.service;

import com.ecommerce.cartservice.entity.CartProducts;
import com.ecommerce.cartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    RestTemplate restTemplate;

    public CartProducts saveProduct(CartProducts product){

        return cartRepository.save(product);
    }

    public List<CartProducts> getAll(){
        List<CartProducts> products = cartRepository.findAll();
        return products;
    }

    public void removeproduct(Long id){

        cartRepository.deleteById(id);
    }

    public String buyProduct(Long id){

        CartProducts product = cartRepository.findById(id).get();
        String result = restTemplate.postForObject("http://ORDER-SERVICE/order/makeOrder", product, String.class);
        return result;
    }
}
