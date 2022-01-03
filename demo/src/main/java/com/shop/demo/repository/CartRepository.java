package com.shop.demo.repository;

import com.shop.demo.domain.CartId;
import com.shop.demo.domain.Cart;

import java.util.List;

public interface CartRepository {

        List<Cart> list();

        Cart findOne(CartId id);

        void create(Cart shoppingCart);

        void update(CartId id, Cart shoppingCart);

        void delete(CartId id);
    }

