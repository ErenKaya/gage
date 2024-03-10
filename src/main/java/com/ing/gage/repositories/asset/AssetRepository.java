package com.ing.gage.repositories.asset;

import com.ing.gage.model.entities.asset.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}