package com.example.Lambdanet.entities;


import com.example.Lambdanet.utils.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

// entity/User.java
@Entity
@Table(name = "users"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Role role;

    @Column(name = "email_verified")
    private boolean emailVerified = false;

    @Column(name = "refresh_token", length = 500)
    private String refreshToken;

    @Column(name = "refresh_token_expires_at")
    private LocalDateTime refreshTokenExpiresAt;
}