package com.ing.gage.model.entities.asset;

import com.ing.gage.model.entities.common.Audit;
import com.ing.gage.model.entities.user.DigitalUser;
import com.ing.gage.model.enums.asset.AssetType;
import jakarta.persistence.*;

@Entity
@Table(name = "asset")
public class Asset extends Audit {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private DigitalUser digitalUser;

    private AssetType type;

    private String name;

    private String content;

    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DigitalUser getUser() {
        return digitalUser;
    }

    public void setUser(DigitalUser digitalUser) {
        this.digitalUser = digitalUser;
    }

    public AssetType getType() {
        return type;
    }

    public void setType(AssetType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
