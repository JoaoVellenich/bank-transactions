package com.joaovellenich.banktransactions.infra.persistence.repository;

import com.joaovellenich.banktransactions.infra.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
