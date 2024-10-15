package com.EmazonPragma.EmazonStock_Pragma.domain.exceptions;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String entity, String message) {
        super(entity + " '" + message + "' already exists");
    }
}