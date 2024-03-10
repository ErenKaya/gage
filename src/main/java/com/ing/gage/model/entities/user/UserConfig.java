package com.ing.gage.model.entities.user;

import com.ing.gage.model.enums.membership.MemberShipType;
import jakarta.persistence.*;

@Entity
@Table(name = "user_config")
public class UserConfig {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private MemberShipType memberShipType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MemberShipType getMemberShipType() {
        return memberShipType;
    }

    public void setMemberShipType(MemberShipType memberShipType) {
        this.memberShipType = memberShipType;
    }
}
