package com.ing.gage.model.entities.user;

import com.ing.gage.model.entities.common.Audit;
import jakarta.persistence.*;

@Entity
@Table(name = "digital_user")
public class DigitalUser extends Audit {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;

    @Column(unique = true)
    private Long identity;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdentity() {
        return identity;
    }

    public void setIdentity(Long identity) {
        this.identity = identity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
