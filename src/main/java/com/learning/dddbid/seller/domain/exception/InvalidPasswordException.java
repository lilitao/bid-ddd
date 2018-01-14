package com.learning.dddbid.seller.domain.exception;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(String message) {
        super(message);
    }
}
