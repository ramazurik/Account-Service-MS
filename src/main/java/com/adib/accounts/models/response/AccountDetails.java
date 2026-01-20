package com.adib.accounts.models.response;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetails {

    private String accountNumber;

    private String accountType;

    private Double accountBalance;


}
