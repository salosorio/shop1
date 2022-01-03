package com.shop.demo.model;

import com.shop.demo.domain.Cart;
import com.shop.demo.domain.Product;

public class CreateProductOutput {
    private Product product;

    public CreateProductOutput() {
    }

    public CreateProductOutput(Product product) {

        this.product = product;
    }

    public Product getProduct() {

        return product;
    }

    public void setProduct(Product product) {

        this.product = product;
    }
}
