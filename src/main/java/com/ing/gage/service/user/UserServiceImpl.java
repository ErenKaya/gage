package com.ing.gage.service.user;

import com.ing.gage.model.dtos.user.UserListItem;
import com.ing.gage.model.dtos.user.UserListResponse;
import com.ing.gage.model.service.UserService;
import com.ing.gage.repositories.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserListResponse list() {
        return new UserListResponse(this.userRepository.findAll().stream().map(digitalUser -> new UserListItem(digitalUser.getId(), digitalUser.getName(), digitalUser.getMail())).toList());
    }
}
