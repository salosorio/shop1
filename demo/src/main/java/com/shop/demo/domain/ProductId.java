package com.shop.demo.domain;

import java.util.UUID;

public class ProductId {


    private final UUID value;

    public ProductId(UUID fromString) {
        this.value = fromString;
    }

    public static ProductId fromString(String id_number) {

        return new ProductId(UUID.fromString(id_number));
    }
    public static ProductId random() {
        return new ProductId(UUID.randomUUID());
    }
    public UUID getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
