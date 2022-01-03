package com.shop.demo.domain;

public class ShoppingProduct {
    private CartId cartId;
    private ProductId productId;
    private Integer quantProd;

    public ShoppingProduct(){

    }
    public ShoppingProduct(CartId cartId, ProductId productId, Integer quantProd) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantProd = quantProd;

    }

    public CartId getCartId() {
        return cartId;
    }

    public void setCartId(CartId cartId) {
        this.cartId = cartId;
    }

    public ProductId getProductId() {
        return productId;
    }

    public void setProductId(ProductId productId) {
        this.productId = productId;
    }

    public Integer getQuantProd() {
        return quantProd;
    }

    public void setQuantProd(Integer quantProd) {
        this.quantProd = quantProd;
    }

}
