package com.ecommerce.catalogservice.service;

import com.ecommerce.catalogservice.entity.CatalogResponse;
import com.ecommerce.catalogservice.entity.Products;
import com.ecommerce.catalogservice.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<CatalogResponse> getAllProducts(){
        List<CatalogResponse> products = new ArrayList<>();
        productsRepository.findAll().forEach(p -> {
            products.add(new CatalogResponse(p.getId(), p.getName(), p.getCompanyName(), p.getPrice()));
        });
        return products;
    }

    public List<CatalogResponse> getAllByCategory(String Category){
        List<CatalogResponse> products = new ArrayList<>();
        productsRepository.findByCategoryEquals(Category).forEach(p -> {
            products.add(new CatalogResponse(p.getId(), p.getName(), p.getCompanyName(), p.getPrice()));
        });

        return products;
    }

    public List<CatalogResponse> getByName(String name){

        List<CatalogResponse> products = new ArrayList<>();
        productsRepository.findByNameEquals(name).forEach(p -> {
            products.add(new CatalogResponse(p.getId(), p.getName(), p.getCompanyName(), p.getPrice()));
        });

        return products;
    }

    public Products getById(Long id){

        Optional<Products> product = productsRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        } else{
            return null;
        }
    }

    public String saveToCart(Products product){

        String result = restTemplate.postForObject("http://CART-SERVICE/cart/saveProduct/ ", product, String.class);
        System.out.println("saved object");
        return result;
    }

    public String buyProduct(Long id){

        Products product = productsRepository.findById(id).get();
        String result = restTemplate.postForObject("http://ORDER-SERVICE/order/makeOrder", product, String.class);
        return result;
    }
}
