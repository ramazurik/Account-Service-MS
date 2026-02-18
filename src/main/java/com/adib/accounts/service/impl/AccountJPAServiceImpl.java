
package com.adib.accounts.service.impl;

import com.adib.accounts.mapper.AccountDetailsMapper;
import com.adib.accounts.models.request.UpdateAccountRequest;
import com.adib.accounts.models.response.AccountDetails;
import com.adib.accounts.persistence.entity.AccountDetailsEntity;
import com.adib.accounts.persistence.repository.AccountDetailsJpaRepository;
import com.adib.accounts.service.AccountJPAService;
import com.adib.accounts.service.AccountService;
import com.adib.accounts.utils.AccountNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AccountJPAServiceImpl implements AccountJPAService {

    @Autowired
    private AccountDetailsJpaRepository accountRepo;

    @Override
    public AccountDetails getAccountByAccountNumber(String accountNumber) {
        AccountDetailsEntity entity = accountRepo.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));

        return AccountDetailsMapper.toDto(entity);
    }

    @Override
    public void createAccount(AccountDetails accountDetails) {
        accountDetails.setAccountNumber(AccountNumberGenerator.generateAccountNumber());
        AccountDetailsEntity entity = AccountDetailsMapper.toEntity(accountDetails);
        //map request model with entity model and save entity using jparepo

        accountRepo.save(entity);

    }



    @Override
    public AccountDetails updateAccountType(UpdateAccountRequest request, String accountNumber) {
        AccountDetailsEntity entity = accountRepo.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));

        if (request.getAccountType() != null)
            entity.setAccountType(request.getAccountType());

        if (request.getAccountBalance() != null)
            entity.setAccountBalance(request.getAccountBalance());

        accountRepo.save(entity);
        return AccountDetailsMapper.toDto(entity);
    }

    @Override
    public void deleteAccount(String accountNumber) {
        AccountDetailsEntity entity = accountRepo.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));
        accountRepo.delete(entity);
    }
}
