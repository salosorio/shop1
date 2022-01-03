package com.shop.demo.model;

import com.shop.demo.domain.ShoppingProduct;

import java.math.BigDecimal;
import java.util.List;

public class UpdateCartInput {

    private List<ShoppingProduct> products;
    private BigDecimal total;

    public UpdateCartInput() {
    }

    public UpdateCartInput( BigDecimal total) {

        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ShoppingProduct> getProducts() {
        return products;
    }

    public void setProducts(List<ShoppingProduct> products) {
        this.products = products;
    }
}
