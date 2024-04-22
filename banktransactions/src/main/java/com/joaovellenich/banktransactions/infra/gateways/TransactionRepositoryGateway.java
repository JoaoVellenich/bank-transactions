package com.joaovellenich.banktransactions.infra.gateways;

import com.joaovellenich.banktransactions.domain.Transactions;
import com.joaovellenich.banktransactions.gataweys.adapters.TransactionGateway;
import com.joaovellenich.banktransactions.infra.persistence.entity.TransactionEntity;
import com.joaovellenich.banktransactions.infra.persistence.mapper.TransactionsMapper;
import com.joaovellenich.banktransactions.infra.persistence.repository.TransactionRepository;

public class TransactionRepositoryGateway implements TransactionGateway {
    private final TransactionsMapper transactionsMapper;
    private  final TransactionRepository transactionRepository;

    public TransactionRepositoryGateway(TransactionsMapper transactionsMapper, TransactionRepository transactionRepository){
        this.transactionsMapper = transactionsMapper;
        this.transactionRepository = transactionRepository;
    }
    @Override
    public Transactions saveTransaction(Transactions transaction) {
        TransactionEntity entity = this.transactionsMapper.toEntity(transaction);
        TransactionEntity saved = this.transactionRepository.save(entity);
        return this.transactionsMapper.toDomain(saved);
    }
}
