package com.thoughtworks_tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class Tokenizer {

    private static final List<String> QUANTIFIER = new ArrayList<String>(Arrays.asList(new String[] { "box", "bottle", "packet" }));

    public static Tokens tokenize(String input) {
        if (StringUtils.isBlank(input))
            throw new IllegalArgumentException("input can not be null or empty");
        boolean isFirstWord = true;
        StringBuilder productNameBuilder = new StringBuilder();
        char[] chars = input.toCharArray();
        StringBuilder builder = new StringBuilder();
        Tokens tokens = new Tokens();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ')
                builder.append(chars[i]);
            else {
                if (isFirstWord) {
                    isFirstWord = false;
                    tokens.setQty(NumberUtils.toInt(builder.toString().trim()));
                    builder.delete(0, builder.length());
                } else {
                    String word = builder.toString();
                    if ("imported".equalsIgnoreCase(word)) {
                        tokens.setContainsImported(true);
                        builder.delete(0, builder.length());
                    } else if ("of".equalsIgnoreCase(word) || QUANTIFIER.contains(word) || "at".equalsIgnoreCase(word)) {
                        builder.delete(0, builder.length());
                    } else {
                        productNameBuilder.append(builder.toString()).append(" ");
                        builder.delete(0, builder.length());
                    }
                }
            }
            if (i == chars.length - 1) {
                tokens.setProductName(productNameBuilder.deleteCharAt(productNameBuilder.length() - 1).toString());
                tokens.setPrice(new BigDecimal(builder.toString().trim()));
                builder.delete(0, builder.length());
            }

        }
        return tokens;
    }
}
