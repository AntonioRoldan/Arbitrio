package com.example.Arbitrio.Services;

import com.example.Arbitrio.utils.UserRoleActionsInterface;
import com.example.Arbitrio.utils.UserRoleDataProviderInterface;
import com.example.Arbitrio.utils.UserRoleFiniteStateMachineProviderInterface;

public class VendorAdminService implements UserRoleActionsInterface {

    private UserRoleDataProviderInterface userRoleDataProvider;

    private UserRoleFiniteStateMachineProviderInterface userRoleFiniteStateMachineProvider;
    @Override
    public <T, TRequest> T getData(TRequest request) {
        return this.userRoleDataProvider.getUserRoleSpecificData();
    }

    @Override
    public <T, TRequest> T postData(TRequest request) {
        return null;
    }

    @Override
    public <T> T performOperation() { //Runs specific statemachine for this user role
        return this.userRoleFiniteStateMachineProvider.run();
    }

    @Override
    public void setUserRoleFiniteStateMachineProvider(UserRoleFiniteStateMachineProviderInterface userRoleFiniteStateMachineProvider) {
        this.userRoleFiniteStateMachineProvider = userRoleFiniteStateMachineProvider;
    }

    @Override
    public void setUserRoleDataProvider(UserRoleDataProviderInterface userRoleDataProvider) {
        this.userRoleDataProvider = userRoleDataProvider;
    }
}
