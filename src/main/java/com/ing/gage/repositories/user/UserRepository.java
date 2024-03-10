package com.ing.gage.repositories.user;

import com.ing.gage.model.entities.user.DigitalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface UserRepository extends JpaRepository<DigitalUser, Long> {
    @Query("select d from DigitalUser d where d.identity = ?1 order by d.identity")
    DigitalUser findByIdentityOrderByIdentityAsc(Long identity);

}