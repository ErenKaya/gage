package com.ing.gage.model.entities.heritage;

import com.ing.gage.model.entities.asset.Asset;
import com.ing.gage.model.entities.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "heritage")
public class Heritage {

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

}
