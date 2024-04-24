package com.joaovellenich.banktransactions.dto.transaction.createTransaction;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CreateTransactionResponseDTO (
        Long transactionId,
        String payerName,
        String receiverName,
        BigDecimal value
){
}
