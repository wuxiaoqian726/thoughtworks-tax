package com.thoughtworks_tax.calculator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.thoughtworks_tax.product.Product;

public class BasicTaxCalculatorTest {

    BasicTaxCalculator basicTaxCalculator = new BasicTaxCalculator();

    @Test
    public void testCalculateBasicTax() {
        Product product = new Product("music CD", new BigDecimal("10"), false);
        BigDecimal tax = basicTaxCalculator.calculate(product);
        Assert.assertEquals(new BigDecimal("1.0"), tax);
    }

}
