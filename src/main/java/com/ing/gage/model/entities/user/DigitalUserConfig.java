package com.ing.gage.model.entities.user;

import com.ing.gage.model.entities.common.Audit;
import com.ing.gage.model.enums.user.MembershipType;
import jakarta.persistence.*;

@Entity
@Table(name = "digital_user_config")
public class DigitalUserConfig extends Audit {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private DigitalUser digitalUser;

    @Column(name = "membership_type")
    private MembershipType membershipType;

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

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }
}
