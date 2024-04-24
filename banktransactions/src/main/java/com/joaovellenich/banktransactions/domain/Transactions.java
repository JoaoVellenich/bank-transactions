package com.joaovellenich.banktransactions.domain;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class Transactions {
    private Long id;
    private User payer;
    private User receiver;
    private BigDecimal value;
}
