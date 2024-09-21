package com.EmazonPragma.EmazonStock_Pragma.infrastructure.exceptions;

public class DuplicateCategoriesException extends RuntimeException{
    public DuplicateCategoriesException(String message) {
        super(message);
    }
}
