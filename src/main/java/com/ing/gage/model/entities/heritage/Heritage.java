package com.ing.gage.model.entities.heritage;

import com.ing.gage.model.entities.asset.Asset;
import com.ing.gage.model.entities.common.Audit;
import com.ing.gage.model.entities.user.User;
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
    private User digitalOwner;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "custodian_user_id")
    private User custodianUser;


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

    public User getDigitalOwner() {
        return digitalOwner;
    }

    public void setDigitalOwner(User digitalOwner) {
        this.digitalOwner = digitalOwner;
    }

    public User getCustodianUser() {
        return custodianUser;
    }

    public void setCustodianUser(User custodianUser) {
        this.custodianUser = custodianUser;
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
