package com.joaovellenich.banktransactions.dto.transaction.createTransaction;

import com.joaovellenich.banktransactions.domain.Transactions;

public class CreateTransactionDTOMapper {
    public CreateTransactionResponseDTO toResponse(Transactions transactions){
        return CreateTransactionResponseDTO.builder()
                .transactionId(transactions.getId())
                .payerName(transactions.getPayer().getFuelName())
                .receiverName(transactions.getReceiver().getFuelName())
                .value(transactions.getValue())
                .build();
    }
}
