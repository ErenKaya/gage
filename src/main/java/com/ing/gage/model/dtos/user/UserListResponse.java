package com.ing.gage.model.dtos.user;

import lombok.*;

import java.util.List;
@Value
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class UserListResponse {

    List<UserListItem> userListItemList;

}
