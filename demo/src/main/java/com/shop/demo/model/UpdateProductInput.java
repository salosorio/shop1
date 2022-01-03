package com.shop.demo.model;

import com.shop.demo.domain.ClientId;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class UpdateProductInput {

    private String name;
    private String description;
    private BigDecimal price;

    public UpdateProductInput() {
    }

    public UpdateProductInput(String name, String description, BigDecimal price) {


        this.name = name;
        this.description= description;
        this.price = price;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
