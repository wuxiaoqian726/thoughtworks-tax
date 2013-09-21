package com.thoughtworks_tax;

import java.math.BigDecimal;

public class Tokens {

    private int qty;
    private boolean containsImported;
    private String productName;
    private BigDecimal price;

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isContainsImported() {
        return containsImported;
    }

    public void setContainsImported(boolean containsImported) {
        this.containsImported = containsImported;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
