package com.example.Arbitrio.controllers;

import com.example.Arbitrio.Services.AuthenticationService;
import com.example.Arbitrio.dtos.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/register/company")
    public ResponseEntity<CompanyAuthResponse> registerCompany(@RequestBody RegisterCompanyRequest request) {
        Long companyId = authService.registerCompany(request);
        return ResponseEntity.ok(new CompanyAuthResponse(companyId));
    }

    @PostMapping("/login/company")
    public ResponseEntity<CompanyAuthResponse> loginCompany(@RequestBody CompanyLoginRequest companyLoginRequest){
        Long companyId = authService.loginCompany(companyLoginRequest);
        return ResponseEntity.ok(new CompanyAuthResponse(companyId));
    }

    @PostMapping("/login/employee")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        String token = authService.authenticateEmployee(request);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register/employee")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        System.out.println("dO I RUN?");

        String token = authService.registerEmployee(request);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}

