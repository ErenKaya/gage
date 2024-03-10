package com.ing.gage.model.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.user.DigitalUser}
 */
@Value
public class UserDto implements Serializable {
    Long id;
    String name;
}