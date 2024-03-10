package com.ing.gage.model.service;

import com.ing.gage.model.dtos.login.CreateUserRequest;
import com.ing.gage.model.dtos.login.LoginResponse;
import com.ing.gage.model.dtos.login.LoginRequest;

public interface LoginViewService {

    LoginResponse login(LoginRequest loginRequest);

    Boolean create(CreateUserRequest createUserRequest);
}
