package com.ing.gage.controller.view;

import com.ing.gage.model.dtos.asset.CreateAssetRequest;
import com.ing.gage.model.dtos.asset.CreatedAsset;
import com.ing.gage.model.dtos.user.UserListResponse;
import com.ing.gage.model.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "list/v1")
    public UserListResponse create() {
        return this.userService.list();
    }
}
