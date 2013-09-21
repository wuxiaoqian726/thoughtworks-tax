package com.thoughtworks_tax;

import java.math.BigDecimal;

import org.junit.Test;

import com.thoughtworks_tax.product.Product;

public class TaxEngineTest {
    private TaxEngine taxEngine = new TaxEngine();

    @Test
    public void testCalculateTaxFreeProduct() {
        Product product = new Product("book", new BigDecimal(10), false);
        System.out.println(taxEngine.calculateTax(product).toString());
    }

    @Test
    public void testCalculateBasicTaxProduct() {
        Product product = new Product("music CD", new BigDecimal(10), false);
        System.out.println(taxEngine.calculateTax(product).toString());
    }

    @Test
    public void testCalculateImportedBasicTaxFreeProduct() {
        Product product = new Product("book", new BigDecimal(10), true);
        System.out.println(taxEngine.calculateTax(product).toString());
    }

    @Test
    public void testCalculateImportedBasicTaxProduct() {
        Product product = new Product("music CD", new BigDecimal(10), true);
        System.out.println(taxEngine.calculateTax(product).toString());
    }
}
