package com.ing.gage.repositories.user;

import com.ing.gage.model.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}