package com.dailycoding.spring.boot.mongoDb.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleEmailAlreadyExistsException(EmailAlreadyExistsException e, HttpServletRequest request) {
       ApiError errorMessage = new ApiError(
               LocalDateTime.now(),
               HttpStatus.BAD_REQUEST.value(),
               "Bad Request",
               e.getMessage(),
               request.getRequestURI()
       );
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericException(Exception e, HttpServletRequest request) {
        ApiError errorMessage = new ApiError(
        LocalDateTime.now(),
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        "Internal Server Error",
        "Something went error!",
        request.getRequestURI()
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request){
        ApiError errorMessage = new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                e.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(IdAlreadyExistsException.class)
    public ResponseEntity<ApiError> handlingIdAlreadyExistException(IdAlreadyExistsException e, HttpServletRequest request){
        ApiError errorMessage = new ApiError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                e.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
