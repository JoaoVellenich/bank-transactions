package com.joaovellenich.banktransactions.infra.persistence.entity;

import com.joaovellenich.banktransactions.domain.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String password;
    private UserType userType;
    private BigDecimal balance;

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String document;
}
