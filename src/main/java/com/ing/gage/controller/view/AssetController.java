package com.ing.gage.controller.view;

import com.ing.gage.model.dtos.asset.CreateAssetRequest;
import com.ing.gage.model.dtos.asset.CreatedAsset;
import com.ing.gage.model.dtos.asset.list.AssetListRequest;
import com.ing.gage.model.dtos.asset.list.AssetListResponse;
import com.ing.gage.model.service.AssetService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/asset")
public class AssetController {


    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping(path = "create/v1", produces = "application/json")
    public CreatedAsset create(@RequestBody @Valid CreateAssetRequest loginRequest) {
        return assetService.create(loginRequest);
    }

    @PostMapping(path = "list/v1", produces = "application/json")
    public AssetListResponse list(@RequestBody @Valid AssetListRequest loginRequest) {
        return assetService.list(loginRequest);
    }
}
