package com.thoughtworks_tax.calculator;

import java.math.BigDecimal;

import org.junit.Test;

import com.thoughtworks_tax.product.Product;

public class ImportedTaxCalculatorTest {

    ImportedTaxCalculator importedTaxCalculator = new ImportedTaxCalculator();

    @Test
    public void testCalculateImportedTax() {
        Product product = new Product("music CD", new BigDecimal("10"), true);
        BigDecimal tax = importedTaxCalculator.calculate(product);
        System.out.println(tax.toString());
    }
}
