package com.ing.gage.service.login;

import com.ing.gage.model.dtos.login.CreateUserRequest;
import com.ing.gage.model.dtos.login.LoginRequest;
import com.ing.gage.model.entities.user.DigitalUser;
import com.ing.gage.repositories.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginViewService {

    private final UserRepository userRepository;

    public LoginViewService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Boolean login(LoginRequest loginRequest) {
        DigitalUser user = userRepository.findByIdentityOrderByIdentityAsc(loginRequest.getIdentity());

        if (user == null) {
            return false;
        }
        return user.getPassword().equals(loginRequest.getPassword());
    }

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
