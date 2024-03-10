package com.ing.gage.model.service;

import com.ing.gage.model.dtos.UserDto;
import com.ing.gage.model.enums.user.MembershipType;

public interface UserConfigService {

    Boolean checkUserRight(UserDto userDto, MembershipType membershipType);
}
