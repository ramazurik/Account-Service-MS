package com.adib.accounts.models.request;

import com.adib.accounts.common.AccountTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAccountRequest {

    private AccountTypeEnum accountType;
    private Double accountBalance;

}