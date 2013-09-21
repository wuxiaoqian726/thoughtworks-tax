package com.thoughtworks_tax.calculator;

import java.math.BigDecimal;

import com.thoughtworks_tax.product.Product;

public class ImportedTaxCalculator implements TaxCalculator {

    private static final BigDecimal IMPORT_TAX_RATE = new BigDecimal("0.05");

    public boolean needToCalculate(Product product) {
        return product.isImported();
    }

    public BigDecimal calculate(Product product) {
        return product.getPrice().multiply(IMPORT_TAX_RATE);
    }

}
