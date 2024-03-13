package com.ing.gage.model.dtos.user;

import java.io.Serializable;

/**
 * DTO for {@link com.ing.gage.model.entities.user.DigitalUser}
 */
public record UserListItem(Long id, String name, String mail) implements Serializable {
}