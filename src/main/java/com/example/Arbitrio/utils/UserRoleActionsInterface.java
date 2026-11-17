package com.example.Arbitrio.utils;

public interface UserRoleActionsInterface {
    UserRoleDataProviderInterface userRoleDataProvider = null;
    <T, TRequest> T getData(TRequest request);
    <T, TRequest> T postData(TRequest request);
    <T> T performOperation();
    void setUserRoleFiniteStateMachineProvider(UserRoleFiniteStateMachineProviderInterface userRoleFiniteStateMachineProvider);
    void setUserRoleDataProvider(UserRoleDataProviderInterface userRoleDataProvider);
}
