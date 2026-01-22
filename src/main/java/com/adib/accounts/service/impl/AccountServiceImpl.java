package com.adib.accounts.service.impl;

import com.adib.accounts.models.request.UpdateAccountRequest;
import com.adib.accounts.models.response.AccountDetails;
import com.adib.accounts.repository.AccountRepository;
import com.adib.accounts.service.AccountService;
import com.adib.accounts.utils.AccountNumberGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDetails getAccountByAccountNumber(String accountNumber) {
        return accountRepository.searchAccountByAccountId(accountNumber);

    }

    @Override
    public void createAccount(AccountDetails accountDetails) {
        //set the account number
        accountDetails.setAccountNumber(AccountNumberGenerator.generateAccountNumber());
        accountRepository.createAccount(accountDetails);
    }
    //added
    @Override
    public AccountDetails updateAccountType(UpdateAccountRequest updateAccountRequest, String accountNumber) {

        //find by account number - call repository
        // update the same object

        AccountDetails accountDetails = accountRepository.searchAccountByAccountId(accountNumber);

        if (accountDetails == null){
            log.error("no account found with the account number {}",accountNumber);
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Account not found"
            );
        }

        if (updateAccountRequest.getAccountType() != null) {
            accountDetails.setAccountType(updateAccountRequest.getAccountType());
        }

        if (updateAccountRequest.getAccountBalance() != null) {
            accountDetails.setAccountBalance(updateAccountRequest.getAccountBalance());
        }
        return accountDetails;
    }


    @Override
    public void deleteAccount(String accountNumber) {
        accountRepository.deleteAccount(accountNumber);
    }
}
