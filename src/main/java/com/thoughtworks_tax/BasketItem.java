package com.thoughtworks_tax;

import java.math.BigDecimal;

import com.thoughtworks_tax.product.Product;

public class BasketItem {

    private final int qty;
    private final Product product;
    private BigDecimal salesTaxs = BigDecimal.ZERO;
    private BigDecimal total = BigDecimal.ZERO;
    private TaxEngine taxEngine = new TaxEngine();

    public BasketItem(int qty, Product product) {
        this.qty = qty;
        this.product = product;
        this.calculatePrice();
    }

    private void calculatePrice() {
        BigDecimal qtyBigDecimal = new BigDecimal(this.qty);
        this.salesTaxs = taxEngine.calculateTax(product).multiply(qtyBigDecimal);
        this.total = product.getPrice().multiply(qtyBigDecimal).add(salesTaxs);
    }

    public BigDecimal getSalesTaxs() {
        return this.salesTaxs;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public int getQty() {
        return qty;
    }

    public Product getProduct() {
        return product;
    }

}
