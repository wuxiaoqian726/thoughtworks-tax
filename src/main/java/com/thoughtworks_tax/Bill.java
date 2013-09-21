package com.thoughtworks_tax;

import java.math.BigDecimal;

public class Bill {

    private final BigDecimal total;
    private final BigDecimal tax;

    public Bill(BigDecimal total, BigDecimal tax) {
        this.total = total;
        this.tax = tax;
    }

    public void print() {
        System.out.println("Sale Taxes:" + tax + "\r\n" + "Total:" + total);
    }
}
