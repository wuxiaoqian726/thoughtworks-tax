package com.thoughtworks_tax;

public class CheckoutCenter {

    public static void Checkout(Basket basket) {
        Bill bill = new Bill(basket.getTotal(), basket.getSalesTaxs());
        bill.print();
    }
}
