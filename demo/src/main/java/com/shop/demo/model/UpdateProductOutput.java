package com.shop.demo.model;

import com.shop.demo.domain.Cart;
import com.shop.demo.domain.Product;

public class UpdateProductOutput {

    private Product product;

    public UpdateProductOutput() {
    }

    public UpdateProductOutput(Product product) {

        this.product = product;
    }

    public Product getProduct() {

        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
