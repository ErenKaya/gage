package com.ing.gage.repositories.user;

import com.ing.gage.model.entities.user.DigitalUserConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserConfigRepository extends JpaRepository<DigitalUserConfig, Long> {
    Optional<DigitalUserConfig> findByDigitalUser_Id(Long id);

}