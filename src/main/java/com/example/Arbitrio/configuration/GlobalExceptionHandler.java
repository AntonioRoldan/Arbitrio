package com.example.Arbitrio.configuration;

import com.example.Arbitrio.dtos.ErrorResponse;
import com.example.Arbitrio.exceptions.InvalidRoleException;
import com.example.Arbitrio.exceptions.NoCompanyIdWasProvidedForEmployeeAuthException;
import com.example.Arbitrio.exceptions.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

    @ExceptionHandler(NoCompanyIdWasProvidedForEmployeeAuthException.class)
    public ResponseEntity<ErrorResponse> handleNoCompanyIdProvidedForEmployeeAuthException(NoCompanyIdWasProvidedForEmployeeAuthException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // Retorna HTTP 400
                .body(errorResponse);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException userAlreadyExistsException) {
        ErrorResponse errorResponse = new ErrorResponse(userAlreadyExistsException.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

}