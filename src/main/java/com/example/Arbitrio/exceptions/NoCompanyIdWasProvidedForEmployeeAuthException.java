package com.example.Arbitrio.exceptions;

public class NoCompanyIdWasProvidedForEmployeeAuthException extends RuntimeException {
    public NoCompanyIdWasProvidedForEmployeeAuthException(String message) {
        super(message);
    }

}
