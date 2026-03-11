package com.productservice.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) { super(message); }
}