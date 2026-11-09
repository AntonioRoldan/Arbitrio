package com.example.Arbitrio.dtos;

public record RegisterRequest(String username, String email, String password, Long companyId, String role) {}
