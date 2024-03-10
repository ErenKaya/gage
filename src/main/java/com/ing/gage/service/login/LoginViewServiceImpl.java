package com.ing.gage.service.login;

import com.ing.gage.model.dtos.login.CreateUserRequest;
import com.ing.gage.model.dtos.login.LoginResponse;
import com.ing.gage.model.dtos.login.LoginRequest;
import com.ing.gage.model.entities.user.DigitalUser;
import com.ing.gage.model.service.LoginViewService;
import com.ing.gage.repositories.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginViewServiceImpl implements LoginViewService {

    private final UserRepository userRepository;

    public LoginViewServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        DigitalUser user = userRepository.findByIdentity(loginRequest.getIdentity()).orElse(null);

        if (checkUserIsNotProperForLogin(user, loginRequest)) {
            return this.createEmptyResponse();
        }
        return this.createLoggedUser(user);
    }

    private LoginResponse createEmptyResponse() {
        return new LoginResponse(null, null, null, null, null, Boolean.FALSE);
    }

    private LoginResponse createLoggedUser(DigitalUser user) {
        return new LoginResponse(user.getId(), user.getName(), user.getIdentity(), user.getCreated(), user.getUpdated(), Boolean.TRUE);

    }

    private static boolean checkUserIsNotProperForLogin(DigitalUser user, LoginRequest loginRequest) {
        return user != null && !user.getPassword().equals(loginRequest.getPassword());
    }

    @Override
    public Boolean create(CreateUserRequest createUserRequest) {
        DigitalUser digitalUser = new DigitalUser();
        digitalUser.setName(createUserRequest.getName());
        digitalUser.setPassword(createUserRequest.getPassword());
        digitalUser.setIdentity(createUserRequest.getIdentity());
        digitalUser.setDeleted(false);
        this.userRepository.save(digitalUser);
        return true;
    }
}
