package com.joaovellenich.banktransactions.infra.controller;

import com.joaovellenich.banktransactions.dto.transaction.createTransaction.CreateTransactionsRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionsController {

    @PostMapping("/")
    public ResponseEntity createTransaction(@RequestBody CreateTransactionsRequestDTO){

    }
}
