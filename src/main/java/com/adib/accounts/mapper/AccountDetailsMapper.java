package com.adib.accounts.mapper;

import com.adib.accounts.persistence.entity.AccountDetailsEntity;
import com.adib.accounts.models.response.AccountDetails;

public class AccountDetailsMapper {

    public static AccountDetails toDto(AccountDetailsEntity entity) {
        return AccountDetails.builder()
                .accountNumber(entity.getAccountNumber())
                .accountType(entity.getAccountType())
                .accountBalance(entity.getAccountBalance())
                .build();
    }

    public static AccountDetailsEntity toEntity(AccountDetails dto) {
        return AccountDetailsEntity.builder()
                .accountNumber(dto.getAccountNumber())
                .accountType(dto.getAccountType())
                .accountBalance(dto.getAccountBalance())
                .build();
    }
}
