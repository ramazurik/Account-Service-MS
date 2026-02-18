package com.adib.accounts.persistence.entity;

import com.adib.accounts.common.AccountTypeEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private AccountTypeEnum accountType;

    @Column(name = "account_balance", nullable = false)
    private Double accountBalance;
}