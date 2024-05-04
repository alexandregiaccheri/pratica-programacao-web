package com.alexandre.programacaoweb.exceptions;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<StandardError> resourceNotFound(NoSuchElementException noSuchElementException) {

        StandardError standardError = new StandardError(
            LocalDateTime.now().toString(),
            HttpStatus.NOT_FOUND,
            noSuchElementException.getMessage(), 
            "O usuário buscado não pode ser encontrado",
            "/users");
        return ResponseEntity.ok(standardError);

    }
    
}
