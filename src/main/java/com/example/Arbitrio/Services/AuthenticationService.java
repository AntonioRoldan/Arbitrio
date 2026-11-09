package com.example.Arbitrio.Services;

import com.example.Arbitrio.dtos.CompanyLoginRequest;
import com.example.Arbitrio.dtos.LoginRequest;
import com.example.Arbitrio.dtos.RegisterCompanyRequest;
import com.example.Arbitrio.dtos.RegisterRequest;
import com.example.Arbitrio.entities.User;
import com.example.Arbitrio.exceptions.InvalidRoleException;
import com.example.Arbitrio.exceptions.NoCompanyIdWasProvidedForEmployeeAuth;
import com.example.Arbitrio.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public Long registerCompany(RegisterCompanyRequest request){
        if(!request.role().equals("COMPANY_ADMIN")){
            throw new InvalidRoleException("Invalid role inserted");
        }
        User company = new User();
        company.setUsername(request.username());
        company.setPassword(request.password());
        company.setRole(request.role());
        userRepository.save(company);

        return company.getId();
    }

    public Long loginCompany(CompanyLoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        User company = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return company.getId();
    }

    public String registerEmployee(RegisterRequest request) {
        List<String> validRoles = new ArrayList<>(List.of("LEGAL_ADMIN", "PROCUREMENT_MANAGER", "FINANCE_ADMIN", "VENDOR_ADMIN"));
        if (!validRoles.contains(request.role())){
            throw new InvalidRoleException("Invalid role inserted");
        }
        User company = userRepository.findById(request.companyId()).orElseThrow( () ->
                new NoCompanyIdWasProvidedForEmployeeAuth("Employees must provide a company id for a registered company when authenticating"));

        User employee = new User();
        employee.setUsername(request.username());

        employee.setPassword(passwordEncoder.encode(request.password()));

        employee.setCompanyId(company.getId());

        employee.setRole(request.role());
        userRepository.save(employee);

        return jwtService.generateToken(employee);
    }

    public String authenticateEmployee(LoginRequest request) {

        User company = userRepository.findById(request.companyId()).orElseThrow(
                () -> new NoCompanyIdWasProvidedForEmployeeAuth("Employees must provide a company id for a registered company when authenticating")
        );

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        User user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return jwtService.generateToken(user);
    }
}
