package com.ing.gage.repositories.user;

import com.ing.gage.model.entities.user.DigitalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<DigitalUser, Long> {
    Optional<DigitalUser> findByIdentity(Long identity);

}