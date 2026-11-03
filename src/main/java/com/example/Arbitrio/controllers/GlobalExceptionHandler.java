package com.example.Arbitrio.controllers;

import com.example.Arbitrio.dtos.AuthResponse;
import com.example.Arbitrio.dtos.ErrorResponse;
import com.example.Arbitrio.exceptions.InvalidRoleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Captura los errores de validación o argumentos incorrectos (ej. rol inválido, usuario duplicado)
    @ExceptionHandler(InvalidRoleException.class)
    public ResponseEntity<ErrorResponse> handleIllegalRoleException(InvalidRoleException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // Retorna HTTP 400
                .body(errorResponse);
    }
}