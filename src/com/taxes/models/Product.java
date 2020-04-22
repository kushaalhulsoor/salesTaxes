package com.taxes.models;

import com.taxes.enums.Book;
import com.taxes.enums.Food;
import com.taxes.enums.Medical;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Product {
    private String name;
    private Float price;
    private Boolean isImported;
    private Boolean isEssential;
    private Float importDuty;
    private Float salesTax;

    public Product(String description) throws Exception{
        this.name = description;
        this.isImported = false;
        this.isEssential = false;
        parseDescriptionToProduct(description);
    }

    public void evaluateSalesTax(){
        this.salesTax = !this.isEssential ? calculateRoundedTax(10.0f) : Float.valueOf(0.0f);
    }

    public void evaluateImportDuty(){
        this.importDuty = this.isImported ? calculateRoundedTax(5.0f) : Float.valueOf(0.0f);
    }

    private Float calculateRoundedTax(Float percent){
        return Math.round((this.price*percent/100)*20)/20.0f;
    }

    private void parseDescriptionToProduct(String description) throws Exception{
        try {
            String[] temp = description.split(" at ");
            this.name = temp[0];
            this.price = Float.parseFloat(temp[1]);
            if (this.price < 0)
                throw new Exception("Invalid Price");
            temp = temp[0].split(" ");
            Set<String> words = new HashSet<>(Arrays.asList(temp));
            if (words.contains("imported"))
                this.isImported = true;
            for (String word : words) {
                if (Food.contains(word.toUpperCase()) || Medical.contains(word.toUpperCase()) || Book.contains(word.toUpperCase())) {
                    this.isEssential = true;
                }
            }
        }catch (Exception e){
            throw new Exception("Error Parsing Product data : " + e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public Float getPrice(){
        return price;
    }

    public Float getImportDuty() {
        return importDuty;
    }

    public Float getSalesTax() {
        return salesTax;
    }
}
