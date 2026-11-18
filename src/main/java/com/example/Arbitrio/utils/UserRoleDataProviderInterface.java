package com.example.Arbitrio.utils;

public interface UserRoleDataProviderInterface {
    <TRequest, TResponse> TResponse getUserRoleSpecificData(TRequest request);
}
