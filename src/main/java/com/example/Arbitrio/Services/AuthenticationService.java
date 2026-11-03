package com.example.Arbitrio.Services;

import com.example.Arbitrio.dtos.LoginRequest;
import com.example.Arbitrio.dtos.RegisterRequest;
import com.example.Arbitrio.entities.User;
import com.example.Arbitrio.exceptions.InvalidRoleException;
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

    public String register(RegisterRequest request) {
        List<String> validRoles = new ArrayList<>(List.of("COMPANY_ADMIN", "LEGAL_ADMIN", "PROCUREMENT_MANAGER", "FINANCE_ADMIN", "VENDOR_ADMIN"));
        if (!validRoles.contains(request.Role())){
            throw new InvalidRoleException("Invalid role inserted");
        }
        User user = new User();
        user.setUsername(request.username());

        user.setPassword(passwordEncoder.encode(request.password()));

        user.setRole(request.Role());
        userRepository.save(user);

        return jwtService.generateToken(user);
    }

    public String authenticate(LoginRequest request) {
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
