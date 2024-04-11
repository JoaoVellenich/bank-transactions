package com.joaovellenich.banktransactions.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transactions {
    private Long id;
    private User payer;
    private User receiver;
    private BigDecimal value;
}
