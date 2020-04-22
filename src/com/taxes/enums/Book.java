package com.taxes.enums;

public enum Book {
    BOOK("BOOK"),
    BOOKS("BOOKS");

    private String value;
    Book(String value){
        this.value = value;
    }

    public static boolean contains(String test) {
        for (Book c : Book.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
