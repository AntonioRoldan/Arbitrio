package com.example.Arbitrio.exceptions;

public class NoCompanyIdWasProvidedForEmployeeAuth extends RuntimeException {
    public NoCompanyIdWasProvidedForEmployeeAuth(String message) {
        super(message);
    }

}
