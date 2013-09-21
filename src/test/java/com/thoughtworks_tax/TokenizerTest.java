package com.thoughtworks_tax;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class TokenizerTest {

    @Test
    public void testTokenizeLineWithSingleWordProductName() {
        String input = "1 book at 12.49";
        Tokens tokens = Tokenizer.tokenize(input);
        Assert.assertEquals(1, tokens.getQty());
        Assert.assertEquals(new BigDecimal("12.49"), tokens.getPrice());
        Assert.assertEquals("book", tokens.getProductName());
        Assert.assertFalse(tokens.isContainsImported());
    }

    @Test
    public void testTokenizeLineWithMultipleWordProductName() {
        String input = "1 chocolate bar at 0.85";
        Tokens tokens = Tokenizer.tokenize(input);
        Assert.assertEquals(1, tokens.getQty());
        Assert.assertEquals(new BigDecimal("0.85"), tokens.getPrice());
        Assert.assertEquals("chocolate bar", tokens.getProductName());
        Assert.assertFalse(tokens.isContainsImported());
    }

    @Test
    public void testTokenizeWithImport() {
        String input = "1 imported bottle of perfume at 47.50";
        Tokens tokens = Tokenizer.tokenize(input);
        Assert.assertEquals(1, tokens.getQty());
        Assert.assertEquals(new BigDecimal("47.50"), tokens.getPrice());
        Assert.assertEquals(tokens.getProductName(), "perfume");
        Assert.assertTrue(tokens.isContainsImported());
    }

    @Test
    public void testTokenizeWithImport2() {
        String input = "1 box of imported chocolates at 11.25";
        Tokens tokens = Tokenizer.tokenize(input);
        Assert.assertEquals(1, tokens.getQty());
        Assert.assertEquals(new BigDecimal("11.25"), tokens.getPrice());
        Assert.assertEquals(tokens.getProductName(), "chocolates");
        Assert.assertTrue(tokens.isContainsImported());
    }

}
