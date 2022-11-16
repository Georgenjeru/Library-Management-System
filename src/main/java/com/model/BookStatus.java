package com.model;

public enum BookStatus {
    ISSUED("ISSUED"),
    NOT_ISSUED("NOT_ISSUED");

    private String status;

    BookStatus(String status) {
        this.status = status;
    }
}
