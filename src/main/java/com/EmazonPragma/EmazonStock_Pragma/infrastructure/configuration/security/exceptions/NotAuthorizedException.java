package com.EmazonPragma.EmazonStock_Pragma.infrastructure.configuration.security.exceptions;

public class NotAuthorizedException extends RuntimeException {
    public NotAuthorizedException(String message) {
        super(message);
    }
}