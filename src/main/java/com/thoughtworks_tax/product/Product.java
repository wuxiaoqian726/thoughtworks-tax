package com.thoughtworks_tax.product;

import java.math.BigDecimal;

public class Product {

    private final ProductCategory productCategory;
    private final String name;
    private final BigDecimal price;
    private final boolean isImported;

    public Product(String name, BigDecimal price, boolean isImported) {
        this.name = name;
        this.productCategory = ProductCategory.getByProductName(name);
        this.price = price;
        this.isImported = isImported;

    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isImported() {
        return isImported;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" of ").append(productCategory.getName()).append(" category with price:").append(price);
        return builder.toString();
    }

}
