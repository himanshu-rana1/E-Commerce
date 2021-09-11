package com.ecommerce.catalogservice.controller;


import com.ecommerce.catalogservice.entity.CatalogResponse;
import com.ecommerce.catalogservice.entity.Products;
import com.ecommerce.catalogservice.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/getAll")
    public List<CatalogResponse> getAllProducts(){

        return catalogService.getAllProducts();
    }

    @GetMapping("/getByCategory")
    public List<CatalogResponse> getAllByCategory(@RequestParam String Category){

        return catalogService.getAllByCategory(Category);
    }

    @GetMapping("/getByName")
    public List<CatalogResponse> getByName(@RequestParam String name){

        return catalogService.getByName(name);
    }

    @GetMapping("/getById")
    public Products getById(@RequestParam Long id){

        return catalogService.getById(id);
    }

    @PostMapping("/saveToCart")
    public String saveToCart(@RequestParam Long id){

        Products product = catalogService.getById(id);
        String result = catalogService.saveToCart(product);
        System.out.println(result);
        return result;
    }

    @GetMapping("/buy/{id}")
    public String buyProduct(@PathVariable Long id){

        String result = catalogService.buyProduct(id);

        return result;
    }
}

