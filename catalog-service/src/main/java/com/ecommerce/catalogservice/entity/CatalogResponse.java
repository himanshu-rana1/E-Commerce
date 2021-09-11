package com.ecommerce.catalogservice.entity;

public class CatalogResponse {

    private Long id;
    private String name;
    private String companyName;
    private Double price;

    public CatalogResponse(Long id, String name, String companyName, Double price) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
