package com.adib.accounts.service.impl;

import com.adib.accounts.models.response.AccountDetails;
import com.adib.accounts.repository.AccountRepository;
import com.adib.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDetails getAccountByAccountNumber(String accountNumber) {
        return accountRepository.searchAccountByAccountId(accountNumber);

    }

    @Override
    public void createAccount(AccountDetails accountDetails) {
        accountRepository.createAccount(accountDetails);
    }

    @Override
    public boolean deleteAccount(String accountNumber) {
        return accountRepository.deleteAccount(accountNumber);
    }
}
