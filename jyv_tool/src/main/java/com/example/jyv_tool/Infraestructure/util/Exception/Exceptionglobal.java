package com.example.jyv_tool.Infraestructure.util.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.jyv_tool.Infraestructure.RepositoryImpl.Herramienta.DuplicateResourceException;
import com.example.jyv_tool.Infraestructure.RepositoryImpl.Herramienta.ResourceNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;

@RestControllerAdvice
public class Exceptionglobal {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<String> handleDuplicateResourceException(DuplicateResourceException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String message = "Los datos proporcionados violan una restricción de la base de datos.";
        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        System.err.println("se esta presentandi un error " + ex.getMessage());
        return new ResponseEntity<>("Ocurrió un error inesperado ", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

