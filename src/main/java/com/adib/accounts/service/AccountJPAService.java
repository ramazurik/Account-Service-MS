package com.adib.accounts.service;

import com.adib.accounts.models.request.UpdateAccountRequest;
import com.adib.accounts.models.response.AccountDetails;

public interface AccountJPAService {

    AccountDetails getAccountByAccountNumber(String accountNumber);

    void createAccount(AccountDetails accountDetails);

    AccountDetails updateAccountType(UpdateAccountRequest updateAccountRequest, String accountNumber);
    void deleteAccount(String accountNumber);

}
