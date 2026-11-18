package com.example.Arbitrio.Services;

import com.example.Arbitrio.dtos.VendorAdmin.VendorGetCompaniesResponse;
import com.example.Arbitrio.dtos.VendorAdmin.VendorGetRequest;
import com.example.Arbitrio.utils.UserRoleFiniteStateMachineProviderInterface;

import java.util.List;

public class VendorAdminService {

    private List<UserRoleFiniteStateMachineProviderInterface> userRoleFiniteStateMachineProviders;

    public VendorAdminService(List<UserRoleFiniteStateMachineProviderInterface> userRoleFiniteStateMachineProviders){
        this.userRoleFiniteStateMachineProviders = userRoleFiniteStateMachineProviders;
    }

    public VendorGetCompaniesResponse getCompaniesToRegisterForData(VendorGetRequest request)
    {
        return null;
    }

    public <TRequest, TResponse> TResponse makeRegistrationRequestAlteringNewRegistrationRequestProcessStatus(TRequest request) { //Runs specific statemachine for this user role
        return null;
    }

}
