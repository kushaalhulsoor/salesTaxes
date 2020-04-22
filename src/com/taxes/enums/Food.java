package com.taxes.enums;

public enum Food {
    CHOCOLATE("CHOCOLATE"),
    CHOCOLATES("CHOCOLATES");

    private String value;
    Food(String value){
        this.value = value;
    }

    public static boolean contains(String test) {
        for (Food c : Food.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
