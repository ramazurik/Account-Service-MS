package com.adib.accounts.persistence.repository;

import com.adib.accounts.persistence.entity.AccountDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountDetailsJpaRepository extends JpaRepository<AccountDetailsEntity, Long> {

    Optional<AccountDetailsEntity> findByAccountNumber(String accountNumber);

    boolean existsByAccountNumber(String accountNumber);
}
