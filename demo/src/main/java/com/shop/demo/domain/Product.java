package com.shop.demo.domain;

public class Product {
    private ProductId id;
    private String name;
    private String description;
    private ProductPrice price;

    public Product(ProductId id, String name, String description, ProductPrice price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductId getId() {
        return id;
    }

    public void setId(ProductId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductPrice getPrice() {
        return price;
    }

    public void setPrice(ProductPrice price) {
        this.price = price;
    }
}
