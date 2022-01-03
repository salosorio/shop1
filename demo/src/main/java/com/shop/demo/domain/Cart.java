package com.shop.demo.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Cart {
    private CartId id;
    private ClientId clientId;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private BigDecimal total;
    private List<ShoppingProduct> products;

    public Cart(CartId id, ClientId clientId, Timestamp createdDate, Timestamp updatedDate, BigDecimal total) {
        this.id = id;
        this.clientId = clientId;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.total = total;
    }

    public Cart(CartId id, Timestamp updatedDate, BigDecimal total) {
        this.id = id;
        this.updatedDate = updatedDate;
        this.total = total;
    }

    public CartId getCartId() {
        return id;
    }

    public void setCartId(CartId cartId) {
        this.id = id;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public void setClientId(ClientId clientId) {
        this.clientId = clientId;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
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
