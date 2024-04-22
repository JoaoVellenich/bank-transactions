package com.joaovellenich.banktransactions.dto.transaction.createTransaction;

import com.joaovellenich.banktransactions.domain.User;

import java.math.BigDecimal;

public record CreateTransactionsRequestDTO(
        Long payerId,
        Long receiverId,
        BigDecimal value
) {
}
