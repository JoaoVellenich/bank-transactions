package com.joaovellenich.banktransactions.infra.persistence.mapper;

import com.joaovellenich.banktransactions.domain.Transactions;
import com.joaovellenich.banktransactions.infra.persistence.entity.TransactionEntity;

public class TransactionsMapper {
    private final UserMapper userMapper;

    public TransactionsMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    public TransactionEntity toEntity(Transactions domain){
        return TransactionEntity.builder()
                .id(domain.getId())
                .payer(this.userMapper.toEntity(domain.getPayer()))
                .receiver(this.userMapper.toEntity(domain.getReceiver()))
                .value(domain.getValue())
                .build();
    }

    public Transactions toDomain(TransactionEntity entity){
        return Transactions.builder()
                .id(entity.getId())
                .payer(this.userMapper.toDomain(entity.getPayer()))
                .receiver(this.userMapper.toDomain(entity.getReceiver()))
                .value(entity.getValue())
                .build();
    }
}
