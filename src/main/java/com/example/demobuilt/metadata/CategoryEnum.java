package com.example.demobuilt.metadata;

public enum CategoryEnum {

    GENERAL("General"),
    TECHNOLOGY("Technology"),
    RANDOM("Random"),
    ;

    private final String label;

    CategoryEnum(String label) {
        this.label = label;
    }
}
