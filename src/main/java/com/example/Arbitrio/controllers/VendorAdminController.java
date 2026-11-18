package com.example.Arbitrio.controllers;

import com.example.Arbitrio.Services.VendorAdminService;
import com.example.Arbitrio.dtos.VendorAdmin.VendorGetCompaniesResponse;
import com.example.Arbitrio.dtos.VendorAdmin.VendorGetRequest;
import com.example.Arbitrio.dtos.VendorAdmin.VendorMakeRegistrationRequestRequest;
import com.example.Arbitrio.dtos.VendorAdmin.VendorMakeRegistrationRequestResponse;
import com.example.Arbitrio.exceptions.FilesNotUploadedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        VendorGetCompaniesResponse reponse = this.vendorAdminService.getCompaniesToRegisterForData(request);
        return ResponseEntity.ok(reponse);
    }

    @PostMapping("/make_request_to_commpany") //This is the only process' status changing method
    public ResponseEntity<VendorMakeRegistrationRequestResponse> makeRegistrationRequestToCompany(@RequestPart("metadata") VendorMakeRegistrationRequestRequest request, @RequestParam("files") List<MultipartFile> files){
        if(files.isEmpty()) {
            throw new FilesNotUploadedException("Files for vendor registration request were not uploaded by vendors");
        }
        //Upload files to the cloud
        VendorMakeRegistrationRequestResponse response = vendorAdminService.makeRegistrationRequestAlteringNewRegistrationRequestProcessStatus(request);
        return ResponseEntity.ok(response);
    }

    //@GetMapping("/ongoing_registration_requests")

    //GetMapping("/ongoing_registration_request_processes") //Shows the process
}
