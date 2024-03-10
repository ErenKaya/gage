package com.ing.gage.service.user;

import com.ing.gage.model.dtos.UserDto;
import com.ing.gage.model.entities.user.DigitalUserConfig;
import com.ing.gage.model.enums.user.MembershipType;
import com.ing.gage.model.service.UserConfigService;
import com.ing.gage.repositories.user.UserConfigRepository;
import jakarta.validation.constraints.Null;
import org.springframework.stereotype.Service;

@Service
public class UserConfigServiceImpl implements UserConfigService {
    private UserConfigRepository userConfigRepository;

    @Override
    public Boolean checkUserRight(UserDto userDto, MembershipType memberShipForContinue) {
        DigitalUserConfig userConfig = this.userConfigRepository.findByDigitalUser_Id(userDto.getId()).orElseThrow(NullPointerException::new);
        return userConfig.getMembershipType().getValue() >= memberShipForContinue.getValue();
    }
}
