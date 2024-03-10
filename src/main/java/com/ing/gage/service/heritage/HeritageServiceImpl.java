package com.ing.gage.service.heritage;

import com.ing.gage.model.dtos.heritage.*;
import com.ing.gage.model.dtos.heritage.get.GetHeritageRequest;
import com.ing.gage.model.entities.heritage.Heritage;
import com.ing.gage.model.entities.user.DigitalUser;
import com.ing.gage.model.service.HeritageService;
import com.ing.gage.repositories.heritage.HeritageRepository;
import com.ing.gage.repositories.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeritageServiceImpl implements HeritageService {
    private final HeritageRepository heritageRepository;
    private final UserRepository userRepository;

    public HeritageServiceImpl(HeritageRepository heritageRepository, UserRepository userRepository) {
        this.heritageRepository = heritageRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<HeritageDTO> getHeritageListByOwnerUser(HeritageListRequest heritageListServiceRequest) {
        DigitalUser user = this.userRepository.findById(heritageListServiceRequest.getUserId()).orElseThrow(NullPointerException::new);
        return this.heritageRepository.findByDigitalOwnerId(user.getId()).stream().map(this::createDTO).toList();
    }

    @Override
    public HeritageDTO get(GetHeritageRequest request) {
        Heritage heritage = this.heritageRepository.findById(request.getId()).orElseThrow(NullPointerException::new);
        return this.createDTO(heritage);
    }

    private HeritageDTO createDTO(Heritage heritage) {
        return new HeritageDTO(heritage.getCreated(), heritage.getUpdated(), heritage.getId(), new OwnerUserDto(heritage.getDigitalOwner().getId(), heritage.getDigitalOwner().getName()), new CustudianUserDTO(heritage.getCustodianUser().getId(), heritage.getCustodianUser().getName()), new HeritageAssetDTO(heritage.getAsset().getId(), heritage.getAsset().getType(), heritage.getAsset().getName(), heritage.getAsset().getContent(), heritage.getAsset().getDescription()), heritage.getNote());
    }
}
