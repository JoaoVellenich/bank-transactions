package com.joaovellenich.banktransactions.infra.controller;

import com.joaovellenich.banktransactions.domain.Transactions;
import com.joaovellenich.banktransactions.dto.transaction.createTransaction.CreateTransactionDTOMapper;
import com.joaovellenich.banktransactions.dto.transaction.createTransaction.CreateTransactionsRequestDTO;
import com.joaovellenich.banktransactions.gataweys.usecases.CreateTransactionUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionsController {
    private final CreateTransactionUseCase createTransactionUseCase;
    private final CreateTransactionDTOMapper createTransactionDTOMapper;

    public TransactionsController(CreateTransactionUseCase createTransactionUseCase, CreateTransactionDTOMapper createTransactionDTOMapper){
        this.createTransactionUseCase = createTransactionUseCase;
        this.createTransactionDTOMapper = createTransactionDTOMapper;
    }

    @PostMapping("/")
    public ResponseEntity createTransaction(@RequestBody CreateTransactionsRequestDTO createTransactionsRequestDTO){
        try{
            Transactions transactions = this.createTransactionUseCase.createTransactionUseCase(createTransactionsRequestDTO);
            return ResponseEntity.ok().body(this.createTransactionDTOMapper.toResponse(transactions));
        }catch (Exception err){
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }
}
