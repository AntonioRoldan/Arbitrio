
package com.example.Arbitrio.entities.VendorRegistrationRequest;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "vendor_registration_requests"
)
@Getter
@Setter
@NoArgsConstructor
public class VendorRegistrationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @ToString.Exclude
    @Column(nullable = true)
    private Long vendorCompanyId; //3 for our tests

    @ToString.Exclude
    @Column(nullable = true)
    private Long companyId; //1 for our tests
}

