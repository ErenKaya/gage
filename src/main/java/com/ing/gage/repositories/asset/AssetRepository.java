package com.ing.gage.repositories.asset;

import com.ing.gage.model.entities.asset.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Long> {
    @Query("select a from Asset a where a.digitalUser.id = ?1")
    List<Asset> findByDigitalUser_Id(Long id);
}