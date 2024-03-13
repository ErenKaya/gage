package com.ing.gage.repositories.transfer;

import com.ing.gage.model.entities.heritage.Heritage;
import com.ing.gage.model.entities.transfer.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransferRepository extends JpaRepository<Transfer, Long> {

    @Query("select h from Transfer h where h.broker.id = ?1")
    List<Transfer> findByTransferId(Long id);
}