package com.ing.gage.model.dtos.login;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.user.DigitalUser}
 */
@Value
public class LoginRequest implements Serializable {
    @NotNull
    Long identity;
    @NotNull
    String password;
}