package com.adib.accounts.repository;

import com.adib.accounts.models.response.AccountDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Repository
@Slf4j
public class AccountRepository {

    private ArrayList<AccountDetails> accountList = new ArrayList<AccountDetails>();

    public AccountRepository() {

        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setAccountBalance(10000.00);
        accountDetails.setAccountNumber("123");
        accountDetails.setAccountType("SAVING");

        AccountDetails accountDetails2 = new AccountDetails();
        accountDetails2.setAccountBalance(20000.00);
        accountDetails2.setAccountNumber("456");
        accountDetails2.setAccountType("CHECKING");

        AccountDetails accountDetails3 = new AccountDetails();
        accountDetails3.setAccountBalance(30000.00);
        accountDetails3.setAccountNumber("789");
        accountDetails3.setAccountType("CREDIT");

        accountList.add(accountDetails);
        accountList.add(accountDetails2);
        accountList.add(accountDetails3);

    }

    public AccountDetails searchAccountByAccountId(String accountNumber) {

        for (AccountDetails acc : accountList) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                log.info("account found");
                return acc;
            }

        }
        log.info("No account found with the account number {}", accountNumber);
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Invalid account data"
        );
    }

    public void createAccount(AccountDetails accountDetails) {
        accountList.add(accountDetails);
    }
    public boolean deleteAccount(String accountNumber) {
        for (AccountDetails acc : accountList) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                accountList.remove(acc);
                return true;
            }
        }
        return false;
}
}