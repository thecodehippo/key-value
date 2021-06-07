package com.javalearning.keyvalue;

public class KeyValue {
    private String value;
    private String key;

    public KeyValue(String value, String key) {
        this.value = value;
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}
