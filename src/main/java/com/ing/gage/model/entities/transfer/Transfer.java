package com.ing.gage.model.entities.transfer;

import com.ing.gage.model.entities.asset.Asset;
import com.ing.gage.model.entities.transfer.payment.Payment;
import com.ing.gage.model.entities.user.DigitalUser;
import com.ing.gage.model.enums.transfer.TransferType;
import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "transfer")
public class Transfer {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private DigitalUser broker;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "asset_id")
    private Asset asset;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    private TransferType type;

    @Column(name = "transfer_date")
    private OffsetDateTime transferDate;

    @Column(name = "consumer_mail")
    private String consumerMail;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DigitalUser getBroker() {
        return broker;
    }

    public void setBroker(DigitalUser broker) {
        this.broker = broker;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public TransferType getType() {
        return type;
    }

    public void setType(TransferType type) {
        this.type = type;
    }

    public OffsetDateTime getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(OffsetDateTime transferDate) {
        this.transferDate = transferDate;
    }


    public String getConsumerMail() {
        return consumerMail;
    }

    public void setConsumerMail(String consumerMail) {
        this.consumerMail = consumerMail;
    }
}
