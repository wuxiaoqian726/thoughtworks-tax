package com.thoughtworks_tax.calculator;

import java.math.BigDecimal;

import com.thoughtworks_tax.product.Product;

public class BasicTaxCalculator implements TaxCalculator {

    private static final BigDecimal BASIC_TAX_RATE = new BigDecimal("0.1");

    public boolean needToCalculate(Product product) {
        return product.getProductCategory().isBasicTaxRequired();
    }

    public BigDecimal calculate(Product product) {
        return product.getPrice().multiply(BASIC_TAX_RATE);
    }
}
