package com.ing.gage.repositories.transfer;

import com.ing.gage.model.entities.transfer.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}