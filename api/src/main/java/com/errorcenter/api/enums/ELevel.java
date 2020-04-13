package com.errorcenter.api.enums;

public enum ELevel {
    ERROR("ERROR"),
    WARNING("WARNING"),
    INFO("INFO");

    private String type;

    ELevel(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }
}
