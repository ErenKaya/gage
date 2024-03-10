package com.ing.gage.controller;

import com.ing.gage.model.dtos.UserDto;
import com.ing.gage.repositories.user.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "api/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<UserDto> userList() {
        return this.userRepository.findAll().stream().map(digitalUser -> new UserDto(digitalUser.getId(), digitalUser.getName())).toList();
    }
}
