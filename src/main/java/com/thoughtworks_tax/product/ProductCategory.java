package com.thoughtworks_tax.product;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ProductCategory {

    public static final ProductCategory BOOKS = new ProductCategory("books", false);
    public static final ProductCategory FOOD = new ProductCategory("food", false);
    public static final ProductCategory MEDICAL = new ProductCategory("medical", false);
    public static final ProductCategory OTHERS = new ProductCategory("other", true);

    public static final Map<List<String>, ProductCategory> MAP = new HashMap<List<String>, ProductCategory>();

    static {
        MAP.put(Arrays.asList(new String[] { "book" }), BOOKS);
        MAP.put(Arrays.asList(new String[] { "chocolate bar", "chocolates" }), FOOD);
        MAP.put(Arrays.asList(new String[] { "headache pills" }), MEDICAL);
        MAP.put(Arrays.asList(new String[] { "music CD", "perfume" }), OTHERS);
    }

    private final String name;
    private final boolean isBasicTaxRequired;

    public ProductCategory(String name, boolean isBasicTaxRequired) {
        this.name = name;
        this.isBasicTaxRequired = isBasicTaxRequired;
    }

    public String getName() {
        return name;
    }

    public boolean isBasicTaxRequired() {
        return isBasicTaxRequired;
    }

    public static ProductCategory getByProductName(String productName) {
        for (Entry<List<String>, ProductCategory> entry : MAP.entrySet()) {
            if (entry.getKey().contains(productName))
                return entry.getValue();
        }
        throw new IllegalArgumentException("Unknown product category of product:" + productName);
    }
}
