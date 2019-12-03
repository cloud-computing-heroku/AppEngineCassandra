package com.example.hello.utils;

public class CustomErrorType {
    private String errorMessage;

    public CustomErrorType() {
    }

    public CustomErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
