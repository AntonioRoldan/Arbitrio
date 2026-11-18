package com.example.Arbitrio.controllers;

import com.example.Arbitrio.Services.VendorAdminGetDataCompaniesProviderService;
import com.example.Arbitrio.Services.VendorAdminService;
import com.example.Arbitrio.dtos.*;
import com.example.Arbitrio.utils.UserRoleDataProviderInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor")
public class VendorAdminController {

    private final VendorAdminService vendorAdminService;

    public VendorAdminController(VendorAdminService vendorAdminService) {
        this.vendorAdminService = vendorAdminService;

    }

    @GetMapping("/companies")
    public ResponseEntity<VendorGetCompaniesResponse> registerCompany(@RequestBody VendorGetRequest request) {
        VendorGetCompaniesResponse reponse = this.vendorAdminService.getCompaniesData(request);
        return ResponseEntity.ok(reponse);
    }

    @PostMapping("/make_request_to_commpany") //This is the only process' status changing method
    public ResponseEntity<VendorMakeRegistrationRequestResponse> makeRegistrationRequestToCompany(@RequestBody VendorMakeRegistrationRequestRequest request){
        VendorMakeRegistrationRequestResponse response = vendorAdminService.makeRegistrationRequestAlteringRegistrationRequestProcessStatus(request);
        return ResponseEntity.ok(response);
    }

    //@GetMapping("/ongoing_registration_requests")

    //GetMapping("/ongoing_registration_request_status")
}
