package com.ing.gage.model.dtos.heritage;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.user.DigitalUser}
 */
@Value
public class CustudianUserDTO implements Serializable {
    Long id;
    String name;
}