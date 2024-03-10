package com.ing.gage.model.dtos.login;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.user.DigitalUser}
 */
@Value
public class CreateUserRequest implements Serializable {
    @NotEmpty(message = "You have to type a name")
    @NotBlank
    String name;
    @NotNull
    @Positive
    Long identity;
    @NotBlank(message = "You have to type a password")
    String password;
}