package com.echenagucia.foroalura.infraestructure.errors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Errors {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity Error404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity Error400(MethodArgumentNotValidException e) {
        var errors = e.getFieldErrors().stream().map(ErrorDataValidation::new).toList();
        return ResponseEntity.badRequest().body(errors);
    }

    private record ErrorDataValidation(String field, String error) {
        public ErrorDataValidation(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
