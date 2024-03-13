package com.ing.gage.service.transfer;

import com.ing.gage.model.dtos.asset.list.DigitalUserDto;
import com.ing.gage.model.dtos.notification.NotificationForInternalUserRequest;
import com.ing.gage.model.dtos.transfer.create.AssetDto;
import com.ing.gage.model.dtos.transfer.create.CreateTransferRequest;
import com.ing.gage.model.dtos.transfer.create.CreateTransferResponse;
import com.ing.gage.model.dtos.transfer.create.PaymentDto;
import com.ing.gage.model.dtos.transfer.get.GetTransferAssetDto;
import com.ing.gage.model.dtos.transfer.get.GetTransferPaymentDto;
import com.ing.gage.model.dtos.transfer.get.GetTransferResponse;
import com.ing.gage.model.entities.asset.Asset;
import com.ing.gage.model.entities.notification.NotificationForExternalRequest;
import com.ing.gage.model.entities.transfer.Transfer;
import com.ing.gage.model.entities.transfer.payment.Payment;
import com.ing.gage.model.entities.user.DigitalUser;
import com.ing.gage.model.enums.notification.NotificationType;
import com.ing.gage.model.service.NotificationService;
import com.ing.gage.model.service.TransferService;
import com.ing.gage.repositories.asset.AssetRepository;
import com.ing.gage.repositories.transfer.TransferRepository;
import com.ing.gage.repositories.user.UserRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TransferServiceImpl implements TransferService {

    private final TransferRepository transferRepository;

    private final AssetRepository assetRepository;

    private final UserRepository userRepository;

    private final NotificationService notificationService;

    public TransferServiceImpl(TransferRepository transferRepository, AssetRepository assetRepository, UserRepository userRepository, NotificationService notificationService) {
        this.transferRepository = transferRepository;
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    @Override
    public CreateTransferResponse create(CreateTransferRequest request) {
        Transfer transfer = this.createTransfer(request);
        Transfer savedTransfer = this.transferRepository.save(transfer);
        Optional<DigitalUser> userOptional = this.userRepository.findByMail(request.getConsumerMail());
        if (userOptional.isPresent()) {
            notificationService.notifyUser(this.createNotifyRequest(savedTransfer, userOptional.get()));
        } else {
            notificationService.notifyUser(this.createNotifyForExternalUser(savedTransfer));
        }

        return this.createTransferResponse(savedTransfer);
    }

    private NotificationForExternalRequest createNotifyForExternalUser(Transfer savedTransfer) {
        return new NotificationForExternalRequest(getTitle(), getContent(savedTransfer), NotificationType.IMPORTANT);
    }


    private NotificationForInternalUserRequest createNotifyRequest(Transfer savedTransfer, DigitalUser digitalUser) {
        return new NotificationForInternalUserRequest(new DigitalUserDto(digitalUser.getId()), getTitle(), getContent(savedTransfer), NotificationType.IMPORTANT);

    }

    private String getContent(Transfer savedTransfer) {
        return String.format("Your order number %d has been placed, please visit http://localhost:8080/payment.html?paymentId=%d to purchase", savedTransfer.getPayment().getId(), savedTransfer.getPayment().getId());
    }

    private String getTitle() {
        return "Order Created";
    }



    @Override
    public List<GetTransferResponse> getTransferByTransferId(Long transferId) {
        DigitalUser user = this.userRepository.findById(transferId).orElseThrow(NullPointerException::new);
        return this.transferRepository.findByTransferId(user.getId()).stream().map(this::createDTO).toList();
    }

    private CreateTransferResponse createTransferResponse(Transfer savedTransfer) {
        return new CreateTransferResponse(savedTransfer.getId(), new AssetDto(savedTransfer.getAsset().getId(), savedTransfer.getAsset().getType(), savedTransfer.getAsset().getName()), new PaymentDto(savedTransfer.getPayment().getId(), savedTransfer.getPayment().getAmount(), savedTransfer.getPayment().getType(), savedTransfer.getPayment().getStatus()), savedTransfer.getType(), savedTransfer.getTransferDate());
    }

    private Transfer createTransfer(CreateTransferRequest request) {
        Transfer transfer = new Transfer();
        Asset asset = this.assetRepository.findById(request.getAsset().getId()).orElseThrow();
        DigitalUser client = this.userRepository.findById(request.getBroker().getId()).orElseThrow();
        transfer.setAsset(asset);
        transfer.setBroker(client);
        transfer.setType(request.getType());
        transfer.setConsumerMail(request.getConsumerMail());
        transfer.setTransferDate(this.createTransferDate(request.getTransferDate()));
        Payment payment = new Payment();
        payment.setAmount(request.getPayment().getAmount());
        transfer.setPayment(payment);
        return transfer;
    }

    private OffsetDateTime createTransferDate(OffsetDateTime transferDate) {
        return Objects.nonNull(transferDate) ? transferDate : OffsetDateTime.now();
    }

    private GetTransferResponse createDTO(Transfer transfer) {
        return new GetTransferResponse(new GetTransferAssetDto(transfer.getAsset().getCreated(), transfer.getAsset().getUpdated(), transfer.getAsset().getId(), transfer.getAsset().getType(), transfer.getAsset().getName()), new GetTransferPaymentDto(transfer.getPayment().getId(), transfer.getPayment().getAmount(), transfer.getPayment().getType()), transfer.getType());
    }
}
