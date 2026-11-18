package com.example.Arbitrio.entities.VendorRegistrationRequest;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// entity/User.java
@Entity
@Table(name = "company_vendor_registration_agreement"
)
@Getter
@Setter
@NoArgsConstructor
public class CompanyVendorRegistrationAgreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @Column(nullable = true)
    private Long companyId;

    @ToString.Exclude
    @Column(nullable = true)
    private Long vendorCompanyId;
}
