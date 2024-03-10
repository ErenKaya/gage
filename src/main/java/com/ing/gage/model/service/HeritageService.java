package com.ing.gage.model.service;

import com.ing.gage.model.dtos.heritage.HeritageDTO;
import com.ing.gage.model.dtos.heritage.HeritageListRequest;
import com.ing.gage.model.dtos.heritage.get.GetHeritageRequest;

import java.util.List;

public interface HeritageService {

    List<HeritageDTO> getHeritageListByOwnerUser(HeritageListRequest heritageListServiceRequest);

    HeritageDTO get(GetHeritageRequest request);
}
