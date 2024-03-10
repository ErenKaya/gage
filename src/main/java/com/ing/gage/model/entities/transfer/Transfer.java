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
    private DigitalUser clientId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "asset_id")
    private Asset asset;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    private TransferType type;

    @Column(name = "transfer_date")
    private OffsetDateTime transferDate;

}
