package com.ing.gage.model.dtos.asset.list;

import com.ing.gage.model.dtos.asset.CreatedAsset;

import java.io.Serializable;
import java.util.List;

public class AssetListResponse implements Serializable {

    List<CreatedAsset> assetList;

    public AssetListResponse(List<CreatedAsset> assetList) {
        this.assetList = assetList;
    }

    public AssetListResponse() {
    }

    public List<CreatedAsset> getAssetList() {
        return assetList;
    }

    public void setAssetList(List<CreatedAsset> assetList) {
        this.assetList = assetList;
    }
}
