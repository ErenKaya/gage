package com.ing.gage.model.service;

import com.ing.gage.model.dtos.asset.CreateAssetRequest;
import com.ing.gage.model.dtos.asset.CreatedAsset;
import com.ing.gage.model.dtos.asset.list.AssetListRequest;
import com.ing.gage.model.dtos.asset.list.AssetListResponse;

public interface AssetService {

    CreatedAsset create(CreateAssetRequest request);

    AssetListResponse list(AssetListRequest request);
}
