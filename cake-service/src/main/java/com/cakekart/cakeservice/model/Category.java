package com.cakekart.cakeservice.model;

public enum Category {
    CHOCOLATE("Chocolate"),BIRTHDAY("Birthday"),FRUIT("Fruit"),
    PREMIUM("Premium");
    private final String value;
    Category(String value){
        this.value=value;
    }

    public static Category fromValue(String value) {
        Category category=null;
        if (value != null) {
            for (Category cg : values()) {
                if (cg.value.equals(value)) {
                    category=cg;
                    break;
                }
            }
        }
    return category;
    }

    public String toValue() {
        return value;
    }
}
