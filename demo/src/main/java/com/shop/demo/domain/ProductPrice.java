package com.shop.demo.domain;

import java.math.BigDecimal;

public class ProductPrice {
    private BigDecimal value;
    private Currency currency; //currency es tipo de moneda como dolar, peso o euro

    public ProductPrice(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public ProductPrice(BigDecimal value) {
        this.value = value;
        this.currency = Currency.COP; //coloca por defecto la moneda COP

    }

    public BigDecimal getValue() {

        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Currency getCurrency() {

        return currency;
    }

    public void setCurrency(Currency currency) {

        this.currency = currency;
    }


}
