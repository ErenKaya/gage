package com.ing.gage.service.asset;

import com.ing.gage.model.dtos.asset.CreateAssetRequest;
import com.ing.gage.model.dtos.asset.CreatedAsset;
import com.ing.gage.model.dtos.asset.list.AssetListRequest;
import com.ing.gage.model.dtos.asset.list.AssetListResponse;
import com.ing.gage.model.dtos.heritage.OwnerUserDto;
import com.ing.gage.model.entities.asset.Asset;
import com.ing.gage.model.entities.user.DigitalUser;
import com.ing.gage.model.service.AssetService;
import com.ing.gage.repositories.asset.AssetRepository;
import com.ing.gage.repositories.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    public AssetServiceImpl(AssetRepository assetRepository, UserRepository userRepository) {
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CreatedAsset create(CreateAssetRequest request) {
        Asset asset = this.createAssetFromRequest(request);
        Asset savedAsset = this.assetRepository.save(asset);
        return this.createAssetResponse(savedAsset);
    }

    @Override
    public AssetListResponse list(AssetListRequest request) {
        List<Asset> assetList = this.assetRepository.findByDigitalUser_Id(request.getDigitalUser().getId());
        return new AssetListResponse(assetList.stream().map(this::createAssetResponse).toList());
    }

    private CreatedAsset createAssetResponse(Asset savedAsset) {
        return new CreatedAsset(savedAsset.getCreated(), savedAsset.getUpdated(), savedAsset.getId(), new OwnerUserDto(savedAsset.getUser().getId(), savedAsset.getUser().getName()), savedAsset.getType(), savedAsset.getName());
    }

    private Asset createAssetFromRequest(CreateAssetRequest request) {
        DigitalUser user = this.userRepository.findById(request.getDigitalUser().getId()).orElseThrow(NullPointerException::new);
        Asset asset = new Asset();
        asset.setUser(user);
        asset.setContent(request.getContent());
        asset.setDescription(request.getDescription());
        asset.setType(request.getType());
        asset.setName(request.getName());
        asset.setDeleted(false);
        return asset;
    }
}
