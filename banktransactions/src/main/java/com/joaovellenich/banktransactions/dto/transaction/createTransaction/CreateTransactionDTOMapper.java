package com.joaovellenich.banktransactions.dto.transaction.createTransaction;

import com.joaovellenich.banktransactions.domain.Transactions;

public class CreateTransactionDTOMapper {
    public CreateTransactionResponseDTO toResponse(Transactions transactions){
        return CreateTransactionResponseDTO.builder()
                .transactionId(transactions.getId())
                .payerName(transactions.getPayer().getFullName())
                .receiverName(transactions.getReceiver().getFullName())
                .value(transactions.getValue())
                .build();
    }
}
