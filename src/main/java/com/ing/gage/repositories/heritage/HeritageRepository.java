package com.ing.gage.repositories.heritage;

import com.ing.gage.model.entities.heritage.Heritage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HeritageRepository extends JpaRepository<Heritage, Long> {

    @Query("select h from Heritage h where h.digitalOwner.id = ?1")
    List<Heritage> findByDigitalOwnerId(Long id);
}