package com.ing.gage.controller.view;

import com.ing.gage.model.dtos.asset.CreateAssetRequest;
import com.ing.gage.model.dtos.asset.CreatedAsset;
import com.ing.gage.model.dtos.transfer.create.CreateTransferRequest;
import com.ing.gage.model.dtos.transfer.create.CreateTransferResponse;
import com.ing.gage.model.dtos.transfer.get.GetTransferResponse;
import com.ing.gage.model.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/transfer")
public class TransferController {


    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }


    @PostMapping(path = "create/v1", produces = "application/json")
    public CreateTransferResponse create(@RequestBody @Valid CreateTransferRequest createRequest) {
        return transferService.create(createRequest);
    }


}
