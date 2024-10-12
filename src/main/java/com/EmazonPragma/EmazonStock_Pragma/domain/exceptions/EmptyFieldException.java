package com.EmazonPragma.EmazonStock_Pragma.domain.exceptions;

public class EmptyFieldException extends RuntimeException {
    public EmptyFieldException(String message) {
        super("Empty '" + message + "' field not allowed");
    }
}
