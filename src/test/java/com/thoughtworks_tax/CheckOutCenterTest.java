package com.thoughtworks_tax;

import org.junit.Test;

public class CheckOutCenterTest {
    @Test
    public void testCheckoutFirstBasket() {
        Basket basket = new Basket();
        basket.purchase("1 book at 12.49");
        basket.purchase("1 music CD at 14.99");
        basket.purchase("1 chocolate bar at 0.85");
        CheckoutCenter.Checkout(basket);
    }

    @Test
    public void testCheckoutSecondBasket() {
        Basket basket = new Basket();
        basket.purchase("1 imported box of chocolates at 10.00");
        basket.purchase("1 imported bottle of perfume at 47.50");
        CheckoutCenter.Checkout(basket);
    }

    @Test
    public void testCheckoutThirdBasket() {
        Basket basket = new Basket();
        basket.purchase("1 imported bottle of perfume at 27.99");
        basket.purchase("1 bottle of perfume at 18.99");
        basket.purchase("1 packet of headache pills at 9.75");
        basket.purchase("1 imported box of chocolates at 11.25");
        CheckoutCenter.Checkout(basket);

        // expected tax:6.70,expected total:74.68;
    }
}
