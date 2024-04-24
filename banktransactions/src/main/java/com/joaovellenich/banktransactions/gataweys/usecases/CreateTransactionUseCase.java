package com.joaovellenich.banktransactions.gataweys.usecases;

import com.joaovellenich.banktransactions.domain.Transactions;
import com.joaovellenich.banktransactions.domain.User;
import com.joaovellenich.banktransactions.domain.UserType;
import com.joaovellenich.banktransactions.dto.transaction.createTransaction.CreateTransactionsRequestDTO;
import com.joaovellenich.banktransactions.gataweys.adapters.TransactionGateway;
import com.joaovellenich.banktransactions.gataweys.adapters.UserGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class CreateTransactionUseCase {
    private final UserGateway userGateway;
    private final TransactionGateway transactionGateway;
    private final RestTemplate restTemplate;

    public CreateTransactionUseCase(UserGateway userGateway, TransactionGateway transactionGateway, RestTemplate restTemplate){
        this.userGateway = userGateway;
        this.transactionGateway = transactionGateway;
        this.restTemplate = restTemplate;
    }

    public Transactions createTransactionUseCase(CreateTransactionsRequestDTO data) throws Exception{
        User payer = this.userGateway.findUserById(data.payerId());
        User receiver = this.userGateway.findUserById(data.receiverId());
        if(payer == null || receiver == null){
            throw new Exception("One of the users is undefined");
        }
        if(payer.getUserType() == UserType.TRADER){
            throw new Exception("This payer can not make a transaction");
        }
        if(payer.getBalance().compareTo(data.value()) < 0){
            throw new Exception(("Payer does not have enough money"));
        }
        ResponseEntity<Map> authorization =  restTemplate.getForEntity("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", Map.class);
        if(authorization.getStatusCode() != HttpStatus.OK || ! authorization.getBody().get("message").equals("Autorizado")){
            throw new Exception("Transaction not authorized");
        }

        payer.setBalance(payer.getBalance().subtract(data.value()));
        receiver.setBalance(receiver.getBalance().add(data.value()));

        this.userGateway.updateBalance(payer.getId(), payer.getBalance());
        this.userGateway.updateBalance(receiver.getId(), receiver.getBalance());

        System.out.println(payer);
        System.out.println(receiver);
        Transactions newTransaction = Transactions.builder()
                .payer(payer)
                .receiver(receiver)
                .value(data.value())
                .build();

        return this.transactionGateway.saveTransaction(newTransaction);

    }
}
