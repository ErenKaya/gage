package com.ing.gage.service.heritage;

import com.ing.gage.model.dtos.heritage.*;
import com.ing.gage.model.dtos.heritage.create.CreateHeritageRequest;
import com.ing.gage.model.dtos.heritage.create.CreatedHeritage;
import com.ing.gage.model.dtos.heritage.get.GetHeritageRequest;
import com.ing.gage.model.dtos.heritage.list.HeritageListRequest;
import com.ing.gage.model.entities.asset.Asset;
import com.ing.gage.model.entities.heritage.Heritage;
import com.ing.gage.model.entities.user.DigitalUser;
import com.ing.gage.model.service.HeritageService;
import com.ing.gage.repositories.asset.AssetRepository;
import com.ing.gage.repositories.heritage.HeritageRepository;
import com.ing.gage.repositories.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeritageServiceImpl implements HeritageService {
    private final HeritageRepository heritageRepository;
    private final UserRepository userRepository;
    private final AssetRepository assetRepository;

    public HeritageServiceImpl(HeritageRepository heritageRepository, UserRepository userRepository, AssetRepository assetRepository) {
        this.heritageRepository = heritageRepository;
        this.userRepository = userRepository;
        this.assetRepository = assetRepository;
    }


    @Override
    public List<HeritageDTO> getHeritageListByOwnerUser(HeritageListRequest heritageListServiceRequest) {
        DigitalUser user = this.userRepository.findById(heritageListServiceRequest.getDigitalOwner().getId()).orElseThrow(NullPointerException::new);
        return this.heritageRepository.findByDigitalOwnerId(user.getId()).stream().map(this::createDTO).toList();
    }

    @Override
    public HeritageDTO get(GetHeritageRequest request) {
        Heritage heritage = this.heritageRepository.findById(request.getId()).orElseThrow(NullPointerException::new);
        return this.createDTO(heritage);
    }

    @Override
    public CreatedHeritage create(CreateHeritageRequest request) {
        Heritage heritage = this.createHeritage(request);
        Heritage savedHeritage = this.heritageRepository.save(heritage);
        return new CreatedHeritage(savedHeritage.getCreated(), savedHeritage.getId());
    }

    private Heritage createHeritage(CreateHeritageRequest request) {
        Heritage heritage = new Heritage();
        Asset asset = this.assetRepository.findById(request.getAsset().getId()).orElseThrow(NullPointerException::new);
        DigitalUser owner = this.userRepository.findById(request.getDigitalOwner().getId()).orElseThrow(NullPointerException::new);
        DigitalUser custodian = this.userRepository.findById(request.getCustodianDigitalUser().getIdentity()).orElseThrow(NullPointerException::new);
        heritage.setAsset(asset);
        heritage.setCustodianUser(custodian);
        heritage.setNote(request.getNote());
        heritage.setDigitalOwner(owner);
        heritage.setDeleted(false);
        return heritage;
    }

    private HeritageDTO createDTO(Heritage heritage) {
        return new HeritageDTO(heritage.getCreated(), heritage.getUpdated(), heritage.getId(), new OwnerUserDto(heritage.getDigitalOwner().getId(), heritage.getDigitalOwner().getName()), new CustudianUserDTO(heritage.getCustodianUser().getId(), heritage.getCustodianUser().getName()), new HeritageAssetDTO(heritage.getAsset().getId(), heritage.getAsset().getType(), heritage.getAsset().getName(), heritage.getAsset().getContent(), heritage.getAsset().getDescription()), heritage.getNote());
    }
}
