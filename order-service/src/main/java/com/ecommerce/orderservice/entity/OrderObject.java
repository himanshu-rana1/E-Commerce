package com.ecommerce.orderservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderObject {

    @Id
    private Long id;
    private String name;
    private String category;
    private String color;
    private String companyName;
    private String description;
    private int quantity;
    private Double price;

    public OrderObject() {
    }

    public OrderObject(Long id, String name, String category, String color, String companyName, String description, int quantity, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.color = color;
        this.companyName = companyName;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
