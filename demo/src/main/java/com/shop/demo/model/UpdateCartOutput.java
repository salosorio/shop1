package com.shop.demo.model;

import com.shop.demo.domain.Cart;

import java.time.LocalDate;

public class UpdateCartOutput {
    private Cart cart;

    public UpdateCartOutput() {
    }

    public UpdateCartOutput(Cart cart) {

        this.cart = cart;
    }

    public Cart getShoppingCart() {

        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
