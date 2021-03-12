package com.tms.store.exception;

public class ProductAlreadyRegisteredException extends Exception {
    public ProductAlreadyRegisteredException(String message) {
        super(message);
    }
}
