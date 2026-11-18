package com.example.Arbitrio.entities.VendorRegistrationRequest;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "vendor_registration_requests_documents"
)
@Getter
@Setter
@NoArgsConstructor
public class VendorRegistrationRequestDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @ToString.Exclude
    @Column(nullable = true)
    private Long registrationRequestId; //3 for our tests


    @ToString.Exclude
    @Column(nullable = true)
    private Long vendorCompanyId; //3 for our tests


    @Column(nullable = true)
    private String owner; //a string like "VENDOR" or a string like "COMPANY"

    @ToString.Exclude
    @Column(nullable = true)
    private Long companyId; //3 for our tests

    @Column(nullable = true)
    private String documentCloudURI;

    @Column(nullable = true)
    private String documentType;

}
