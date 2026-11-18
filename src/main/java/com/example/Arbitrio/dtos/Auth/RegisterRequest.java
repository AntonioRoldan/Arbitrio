package com.example.Arbitrio.dtos.Auth;

public record RegisterRequest(String username, String email, String password, Long companyId, String role) {}
