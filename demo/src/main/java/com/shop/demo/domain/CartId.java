package com.shop.demo.domain;

import java.util.UUID;

//clase
public class CartId {

    //
    private final UUID value;

    public CartId(UUID fromString) {
        this.value = fromString;
    }

    public static CartId fromString(String unsafeValue) {

        return new CartId(UUID.fromString(unsafeValue));
    }
    public static CartId random() {
        return new CartId(UUID.randomUUID());
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

