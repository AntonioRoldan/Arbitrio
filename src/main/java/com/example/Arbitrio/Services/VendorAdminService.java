package com.example.Arbitrio.Services;

import com.example.Arbitrio.dtos.VendorGetCompaniesResponse;
import com.example.Arbitrio.dtos.VendorGetRequest;
import com.example.Arbitrio.utils.UserRoleDataProviderInterface;
import com.example.Arbitrio.utils.UserRoleFiniteStateMachineProviderInterface;

import java.util.List;

public class VendorAdminService {

    private List<UserRoleDataProviderInterface> userRoleDataProviders;

    private List<UserRoleFiniteStateMachineProviderInterface> userRoleFiniteStateMachineProviders;

    public VendorAdminService(List<UserRoleFiniteStateMachineProviderInterface> userRoleFiniteStateMachineProviders, List<UserRoleDataProviderInterface> userRoleDataProvidersInterfaces){
        this.userRoleFiniteStateMachineProviders = userRoleFiniteStateMachineProviders;
        this.userRoleDataProviders = userRoleDataProvidersInterfaces;
    }

    public VendorGetCompaniesResponse getCompaniesData(VendorGetRequest request)
    {
        UserRoleDataProviderInterface userRoleDataProviderInterface = this.userRoleDataProviders.stream()
                .filter(VendorAdminGetDataCompaniesProviderService.class::isInstance)
                .findFirst()
                .orElseThrow();
        return userRoleDataProviderInterface.getUserRoleSpecificData(request);
    }

    public <T> T updateRegistrationRequestProcessStatus() { //Runs specific statemachine for this user role
        return null;
    }

}
