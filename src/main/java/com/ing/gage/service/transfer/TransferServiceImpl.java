package com.ing.gage.service.transfer;

import com.ing.gage.model.dtos.transfer.create.AssetDto;
import com.ing.gage.model.dtos.transfer.create.CreateTransferRequest;
import com.ing.gage.model.dtos.transfer.create.CreateTransferResponse;
import com.ing.gage.model.dtos.transfer.create.PaymentDto;
import com.ing.gage.model.entities.asset.Asset;
import com.ing.gage.model.entities.transfer.Transfer;
import com.ing.gage.model.entities.transfer.payment.Payment;
import com.ing.gage.model.entities.user.DigitalUser;
import com.ing.gage.model.service.TransferService;
import com.ing.gage.repositories.asset.AssetRepository;
import com.ing.gage.repositories.transfer.TransferRepository;
import com.ing.gage.repositories.user.UserRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Objects;

@Service
public class TransferServiceImpl implements TransferService {

    private final TransferRepository transferRepository;

    private final AssetRepository assetRepository;

    private final UserRepository userRepository;

    public TransferServiceImpl(TransferRepository transferRepository, AssetRepository assetRepository, UserRepository userRepository) {
        this.transferRepository = transferRepository;
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CreateTransferResponse create(CreateTransferRequest request) {
        Transfer transfer = this.createTransfer(request);
        Transfer savedTransfer = this.transferRepository.save(transfer);
        return this.createTransferResponse(savedTransfer);
    }

    private CreateTransferResponse createTransferResponse(Transfer savedTransfer) {
        return new CreateTransferResponse(savedTransfer.getId(), new AssetDto(savedTransfer.getAsset().getId(), savedTransfer.getAsset().getType(), savedTransfer.getAsset().getName()), new PaymentDto(savedTransfer.getPayment().getId(), savedTransfer.getPayment().getAmount(), savedTransfer.getPayment().getType(), savedTransfer.getPayment().getStatus()), savedTransfer.getType(), savedTransfer.getTransferDate());
    }

    private Transfer createTransfer(CreateTransferRequest request) {
        Transfer transfer = new Transfer();
        Asset asset = this.assetRepository.findById(request.getAsset().getId()).orElseThrow();
        DigitalUser client = this.userRepository.findById(request.getClientId().getId()).orElseThrow();
        transfer.setAsset(asset);
        transfer.setClientId(client);
        transfer.setTransferDate(this.createTransferDate(request.getTransferDate()));
        Payment payment = new Payment();
        payment.setAmount(request.getPayment().getAmount());
        transfer.setPayment(payment);
        return transfer;
    }

    private OffsetDateTime createTransferDate(OffsetDateTime transferDate) {
        return Objects.nonNull(transferDate) ? transferDate : OffsetDateTime.now();
    }
}
