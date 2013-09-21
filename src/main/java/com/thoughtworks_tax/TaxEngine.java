package com.thoughtworks_tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks_tax.calculator.BasicTaxCalculator;
import com.thoughtworks_tax.calculator.ImportedTaxCalculator;
import com.thoughtworks_tax.calculator.TaxCalculator;
import com.thoughtworks_tax.product.Product;

public class TaxEngine {

    private static final List<TaxCalculator> CONFIG_TAX_CALCULATORS = new ArrayList<TaxCalculator>();

    static {
        CONFIG_TAX_CALCULATORS.add(new BasicTaxCalculator());
        CONFIG_TAX_CALCULATORS.add(new ImportedTaxCalculator());
    }

    public BigDecimal calculateTax(Product product) {
        BigDecimal tax = BigDecimal.ZERO;
        for (TaxCalculator taxCalculator : CONFIG_TAX_CALCULATORS) {
            if (taxCalculator.needToCalculate(product))
                tax = tax.add(taxCalculator.calculate(product));
        }
        return tax;
    }
}
