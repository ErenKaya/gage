package com.ing.gage.model.dtos.heritage;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

public class HeritageListRequest implements Serializable {
    @NotNull
    private Long userId;


    public HeritageListRequest(Long userId) {
        this.userId = userId;
    }

    public HeritageListRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}