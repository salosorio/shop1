package com.shop.demo.model;

import com.shop.demo.domain.Cart;

public class CreateCartOutput {
    private Cart cart;

    public CreateCartOutput() {
    }

    public CreateCartOutput(Cart cart) {

        this.cart = cart;
    }

    public Cart getCart() {

        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
