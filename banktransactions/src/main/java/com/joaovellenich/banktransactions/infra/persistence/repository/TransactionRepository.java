package com.joaovellenich.banktransactions.infra.persistence.repository;

import com.joaovellenich.banktransactions.infra.persistence.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
