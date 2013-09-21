package com.thoughtworks_tax;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class BigDecimalTest {

    @Test
    public void testMayHasErrors() {
        System.out.println(0.05 + 0.01);
        System.out.println(1.0 - 0.42);
        System.out.println(4.015 * 100);
        System.out.println(123.3 / 100);
    }

    @Test
    public void test1() {
        BigDecimal bigDecimal = new BigDecimal(0.1);
        System.out.println(bigDecimal.toString());

        BigDecimal bigDecimal2 = new BigDecimal("0.1");
        System.out.println(bigDecimal2.toString());
    }

    @Test
    public void test2() {
        double b = 0.1;
        System.out.println(b * 23.78 * 4.222);

        BigDecimal bigDecimal1 = new BigDecimal(0.1);
        BigDecimal bigDecimal2 = new BigDecimal(23.78);
        bigDecimal2 = bigDecimal1.multiply(bigDecimal2).setScale(2, RoundingMode.HALF_UP);
        BigDecimal bigDecimal3 = new BigDecimal(4.222);
        System.out.println(bigDecimal2.multiply(bigDecimal3).setScale(2, RoundingMode.HALF_UP));
    }
}
