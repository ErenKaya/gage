package com.ing.gage.controller.view;

import com.ing.gage.model.dtos.login.CreateUserRequest;
import com.ing.gage.model.dtos.login.LoginResponse;
import com.ing.gage.model.dtos.login.LoginRequest;
import com.ing.gage.model.service.LoginViewService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/start")
public class LoginViewController {

    private final LoginViewService loginViewService;

    public LoginViewController(LoginViewService loginViewService) {
        this.loginViewService = loginViewService;
    }


    @PostMapping(path = "login/v1", produces = "application/json")
    public LoginResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return loginViewService.login(loginRequest);
    }

    @PostMapping(path = "create/v1", produces = "application/json")
    public Boolean create(@RequestBody @Valid CreateUserRequest createUserRequest) {
        return loginViewService.create(createUserRequest);
    }
}
