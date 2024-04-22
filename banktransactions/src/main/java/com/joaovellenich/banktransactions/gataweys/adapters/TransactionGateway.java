package com.joaovellenich.banktransactions.gataweys.adapters;

import com.joaovellenich.banktransactions.domain.Transactions;

public interface TransactionGateway {
    Transactions saveTransaction(Transactions transaction);
}
