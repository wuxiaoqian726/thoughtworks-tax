package com.thoughtworks_tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.thoughtworks_tax.product.Product;

public class Basket {

    private final List<BasketItem> basketItems = new ArrayList<BasketItem>();

    public void purchase(String input) {
        Tokens tokens = Tokenizer.tokenize(input);
        Product product = new Product(tokens.getProductName(), tokens.getPrice(), tokens.isContainsImported());
        basketItems.add(new BasketItem(tokens.getQty(), product));
    }

    public List<BasketItem> getBasketItems() {
        return Collections.unmodifiableList(basketItems);
    }

    public BigDecimal getSalesTaxs() {
        BigDecimal salesTaxs = BigDecimal.ZERO;
        for (BasketItem basketItem : this.basketItems) {
            salesTaxs = salesTaxs.add(basketItem.getSalesTaxs());
        }
        return salesTaxs;
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (BasketItem basketItem : this.basketItems) {
            total = total.add(basketItem.getTotal());
        }
        return total;
    }

}
