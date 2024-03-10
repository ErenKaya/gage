package com.ing.gage.model.dtos.login;

import lombok.Value;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * DTO for {@link com.ing.gage.model.entities.user.DigitalUser}
 */
@Value
public class LoginResponse implements Serializable {
    Long id;
    String name;
    Long identity;
    OffsetDateTime created;
    OffsetDateTime updated;
    Boolean isSuccess;

    public LoginResponse(Long id, String name, Long identity, OffsetDateTime created, OffsetDateTime updated, Boolean isSuccess) {
        this.id = id;
        this.name = name;
        this.identity = identity;
        this.created = created;
        this.updated = updated;
        this.isSuccess = isSuccess;
    }
}