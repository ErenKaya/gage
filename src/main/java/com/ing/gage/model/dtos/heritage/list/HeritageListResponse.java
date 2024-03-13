package com.ing.gage.model.dtos.heritage.list;

import com.ing.gage.model.dtos.heritage.HeritageDTO;

import java.io.Serializable;
import java.util.List;

public class HeritageListResponse implements Serializable {

    List<HeritageDTO> assetList;

    public List<HeritageDTO> getAssetList() {
        return assetList;
    }

    public void setAssetList(List<HeritageDTO> assetList) {
        this.assetList = assetList;
    }
}
