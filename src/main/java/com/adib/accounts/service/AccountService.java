package com.adib.accounts.service;

import com.adib.accounts.models.response.AccountDetails;

public interface AccountService {

    AccountDetails getAccountByAccountNumber(String accountNumber);

    void createAccount(AccountDetails accountDetails);

    boolean deleteAccount(String accountNumber);

}
