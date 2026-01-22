package com.adib.accounts.models.response;

import com.adib.accounts.common.AccountTypeEnum;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetails {

    private String accountNumber;
    private AccountTypeEnum accountType;
    private Double accountBalance;
}
