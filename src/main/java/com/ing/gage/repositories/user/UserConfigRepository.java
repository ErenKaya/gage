package com.ing.gage.repositories.user;

import com.ing.gage.model.entities.user.DigitalUserConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserConfigRepository extends JpaRepository<DigitalUserConfig, Long> {
}