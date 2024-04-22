package com.joaovellenich.banktransactions.infra.persistence.entity;

import com.joaovellenich.banktransactions.domain.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "TransactionEntity")
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode(of = "id")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity payer;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private UserEntity receiver;
    private BigDecimal value;
    @CreatedDate
    private LocalDateTime createdAt;
}