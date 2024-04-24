package com.joaovellenich.banktransactions.config;

import com.joaovellenich.banktransactions.dto.transaction.createTransaction.CreateTransactionDTOMapper;
import com.joaovellenich.banktransactions.gataweys.adapters.TransactionGateway;
import com.joaovellenich.banktransactions.gataweys.adapters.UserGateway;
import com.joaovellenich.banktransactions.gataweys.usecases.CreateTransactionUseCase;
import com.joaovellenich.banktransactions.infra.gateways.TransactionRepositoryGateway;
import com.joaovellenich.banktransactions.infra.persistence.mapper.TransactionsMapper;
import com.joaovellenich.banktransactions.infra.persistence.mapper.UserMapper;
import com.joaovellenich.banktransactions.infra.persistence.repository.TransactionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TransactionsConfig {
    @Bean
    public CreateTransactionUseCase createTransactionUseCase(UserGateway userGateway, TransactionGateway transactionGateway){
        return new CreateTransactionUseCase(userGateway, transactionGateway, new RestTemplate());
    }
    @Bean
    public TransactionGateway transactionGateway(TransactionRepository transactionRepository, TransactionsMapper transactionsMapper){
        return new TransactionRepositoryGateway(transactionsMapper, transactionRepository);
    }
    @Bean
    public TransactionsMapper transactionsMapper(UserMapper userMapper){return new TransactionsMapper(userMapper);}
    @Bean
    public CreateTransactionDTOMapper createTransactionDTOMapper(){return new CreateTransactionDTOMapper();}
}
