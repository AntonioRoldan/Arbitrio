package com.example.Arbitrio.dtos;

public record RegisterRequest(String username, String password, Long companyId, String role) {}
