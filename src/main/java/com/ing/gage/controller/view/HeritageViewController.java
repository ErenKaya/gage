package com.ing.gage.controller.view;

import com.ing.gage.model.dtos.heritage.HeritageDTO;
import com.ing.gage.model.dtos.heritage.create.CreateHeritageRequest;
import com.ing.gage.model.dtos.heritage.create.CreatedHeritage;
import com.ing.gage.model.dtos.heritage.get.GetHeritageRequest;
import com.ing.gage.model.dtos.heritage.list.HeritageListRequest;
import com.ing.gage.model.dtos.heritage.list.HeritageListResponse;
import com.ing.gage.model.service.HeritageService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/heritage")
public class HeritageViewController {

    private final HeritageService heritageService;

    public HeritageViewController(HeritageService heritageService) {
        this.heritageService = heritageService;
    }

    @PostMapping(path = "list/v1", produces = "application/json")
    public HeritageListResponse list(@RequestBody @Valid HeritageListRequest loginRequest) {
        return heritageService.getHeritageListByOwnerUser(loginRequest);
    }

    @PostMapping(path = "get/v1", produces = "application/json")
    public HeritageDTO get(@RequestBody @Valid GetHeritageRequest loginRequest) {
        return heritageService.get(loginRequest);
    }

    @PostMapping(path = "create/v1", produces = "application/json")
    public CreatedHeritage create(@RequestBody @Valid CreateHeritageRequest loginRequest) {
        return heritageService.create(loginRequest);
    }

}
