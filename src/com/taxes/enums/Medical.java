package com.taxes.enums;

public enum Medical {
    PILL("PILL"),
    PILLS("PILLS");

    private String value;
    Medical(String value){
        this.value = value;
    }

    public static boolean contains(String test) {
        for (Medical c : Medical.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
