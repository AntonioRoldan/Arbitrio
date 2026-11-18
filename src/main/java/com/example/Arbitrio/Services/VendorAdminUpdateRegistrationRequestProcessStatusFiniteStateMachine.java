package com.example.Arbitrio.Services;

import com.example.Arbitrio.utils.FiniteStateMachineState;
import com.example.Arbitrio.utils.UserRoleFiniteStateMachineProviderInterface;

import java.util.ArrayList;
import java.util.List;

public class VendorAdminUpdateRegistrationRequestProcessStatusFiniteStateMachine implements UserRoleFiniteStateMachineProviderInterface {
    @Override
    public <TRequest, TResponse> TResponse run(TRequest request){
        //First we sanitize inputs to avoid a malicious client from making unallowed status changes by this user role
        List<String> validCurrentStates = new ArrayList<>();
        List<String> validNextStates = new ArrayList<>();
        List<FiniteStateMachineState> fsmStatesTable = new ArrayList<>();
        //We instantiate the states
        //Store them in our table
        return null; //Implement finite state machine here
    }
}
