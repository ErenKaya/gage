package com.ing.gage.model.entities.heritage;

import com.ing.gage.model.entities.asset.Asset;
import com.ing.gage.model.entities.common.Audit;
import com.ing.gage.model.entities.user.DigitalUser;
import jakarta.persistence.*;

@Entity
@Table(name = "heritage")
public class Heritage extends Audit {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "digital_owner_user_id")
    private DigitalUser digitalOwner;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "custodian_user_id")
    private DigitalUser custodianDigitalUser;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "asset_id")
    private Asset asset;


    private String note;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DigitalUser getDigitalOwner() {
        return digitalOwner;
    }

    public void setDigitalOwner(DigitalUser digitalOwner) {
        this.digitalOwner = digitalOwner;
    }

    public DigitalUser getCustodianUser() {
        return custodianDigitalUser;
    }

    public void setCustodianUser(DigitalUser custodianDigitalUser) {
        this.custodianDigitalUser = custodianDigitalUser;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
