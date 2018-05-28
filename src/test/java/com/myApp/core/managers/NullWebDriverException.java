package com.myApp.core.managers;

public class NullWebDriverException extends Exception {

    public NullWebDriverException() {
        this("The current WebDriver must not be null.");
    }

    public NullWebDriverException(String message) {
        super(message);
    }

}
