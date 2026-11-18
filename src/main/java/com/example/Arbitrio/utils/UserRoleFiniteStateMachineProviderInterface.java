package com.example.Arbitrio.utils;

public interface UserRoleFiniteStateMachineProviderInterface {
    <TRequest, TResponse> TResponse run(TRequest request);
}
