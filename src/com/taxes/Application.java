package com.taxes;

import com.taxes.models.Product;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String temp, answer = "";
        float total = 0.0f, salesTax = 0.0f;
        while((temp = reader.readLine())!=null && !temp.isEmpty()){
            //Create a Product
            Product product = new Product(temp);
            product.evaluateSalesTax();
            product.evaluateImportDuty();

            //Calculate bill
            float finalPrice = product.getPrice()+product.getSalesTax()+product.getImportDuty();
            float finalTax = finalPrice - product.getPrice();

            //Accumulate answer
            answer = String.format("%s%s: %.2f\n", answer, product.getName(), finalPrice);
            total += finalPrice;
            salesTax += finalTax;
        }
        System.out.println(String.format("%sSales Taxes: %.2f\nTotal: %.2f\n==========", answer, salesTax, total));
    }
}
