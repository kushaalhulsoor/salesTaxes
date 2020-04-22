package com.taxes.tests;

import com.taxes.models.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void positiveTestCase() throws Exception {
        Product product = new Product("1 imported bottle of perfume at 27.99");
        product.evaluateSalesTax();
        product.evaluateImportDuty();
        assertEquals(String.format("%.2f",product.getPrice()+product.getSalesTax()+product.getImportDuty()), "32.19");
    }

    @Test
    void negativeTestCase_1() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
                    Product product = new Product("1 imported bottle of perfume at -27.99");
                    product.evaluateSalesTax();
                    product.evaluateImportDuty();
                });
        assertEquals("Error Parsing Product data : Invalid Price", exception.getMessage());
    }


    @Test
    void negativeTestCase_2() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            Product product = new Product("this is a book of worth hundred bucks");
            product.evaluateSalesTax();
            product.evaluateImportDuty();
        });
        assertEquals("Error Parsing Product data : Index 1 out of bounds for length 1", exception.getMessage());
    }
}