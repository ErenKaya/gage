package com.ing.gage.model.service;

import com.ing.gage.model.dtos.heritage.HeritageDTO;
import com.ing.gage.model.dtos.heritage.create.CreateHeritageRequest;
import com.ing.gage.model.dtos.heritage.create.CreatedHeritage;
import com.ing.gage.model.dtos.heritage.get.GetHeritageRequest;
import com.ing.gage.model.dtos.heritage.list.HeritageListRequest;

import java.util.List;

public interface HeritageService {

    List<HeritageDTO> getHeritageListByOwnerUser(HeritageListRequest heritageListServiceRequest);

    HeritageDTO get(GetHeritageRequest request);

    CreatedHeritage create(CreateHeritageRequest request);

}
