package com.example.Arbitrio.entities.VendorRegistrationRequest;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "vendor_registration_request_processes"
)
@Getter
@Setter
@NoArgsConstructor
public class VendorRegistrationRequestProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(nullable = false, length = 100)
    private String processType; //VendorRegistrationRequestProcess

    @Column(nullable = false, length = 100)
    private String processStatus; //VENDOR_DOCUMENTS_SENT, VENDOR_AND_COMPANY_DOCUMENTS_SENT, VENDOR_AND_COMPANY_DOCUMENTS_APPROVED, REJECTED, CANCELLED, FINISHED

    @ToString.Exclude
    @Column(nullable = true)
    private Long vendorRegistrationRequestId;

    @ToString.Exclude
    @Column(nullable = true)
    private Long vendorCompanyId;

    @ToString.Exclude
    @Column(nullable = true)
    private Long companyId;
}

