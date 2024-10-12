package com.EmazonPragma.EmazonStock_Pragma.domain.exceptions;

public class DuplicatedProductCategoryException extends RuntimeException {
    public DuplicatedProductCategoryException(String message) {
        super(message);
    }
}
