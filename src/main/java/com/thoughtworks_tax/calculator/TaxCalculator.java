package com.thoughtworks_tax.calculator;

import java.math.BigDecimal;

import com.thoughtworks_tax.product.Product;

public interface TaxCalculator {

    boolean needToCalculate(Product product);

    BigDecimal calculate(Product product);
}
