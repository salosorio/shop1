package com.shop.demo.model;

import com.shop.demo.domain.CartId;
import com.shop.demo.domain.ClientId;
import com.shop.demo.domain.ShoppingProduct;

import java.math.BigDecimal;

import java.util.List;

public class CreateCartInput {

    private List<ShoppingProduct> products;
    private ClientId clientId;
    private BigDecimal total;

    public CreateCartInput() {
    }

    public CreateCartInput(ClientId clientId,  BigDecimal total) {
        this.clientId = clientId;
        this.total = total;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public void setClientId(ClientId clientId) {
        this.clientId = clientId;
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
