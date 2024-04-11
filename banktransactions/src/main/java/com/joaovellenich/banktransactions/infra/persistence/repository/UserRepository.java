package com.joaovellenich.banktransactions.infra.persistence.repository;

import com.joaovellenich.banktransactions.infra.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByDocument(String document);
}
