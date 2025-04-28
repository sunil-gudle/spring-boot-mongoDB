package com.dailycoding.spring.boot.mongoDb.exception;

public class IdAlreadyExistsException extends RuntimeException{

    public IdAlreadyExistsException(String message){
        super(message);
    }
}
