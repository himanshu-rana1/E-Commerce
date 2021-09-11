package com.ecommerce.cartservice.controller;


import com.ecommerce.cartservice.entity.CartProducts;
import com.ecommerce.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/saveProduct")
    public String saveProduct ( @RequestBody CartProducts product){

        CartProducts productObject =  cartService.saveProduct(product);

        if(productObject != null)
            return "Item added to the cart";
        else
            return "Item cannot be added in the cart";
    }

    @GetMapping("/getAll")
    public List<CartProducts> getAllProducts(){
        return cartService.getAll();
    }

    @PostMapping("/remove")
    public void removeProduct(@RequestParam Long id){
        cartService.removeproduct(id);
    }

    @GetMapping("/buy/{id}")
    public String buyProduct(@PathVariable Long id){

        String result = cartService.buyProduct(id);

        return result;
    }
}
