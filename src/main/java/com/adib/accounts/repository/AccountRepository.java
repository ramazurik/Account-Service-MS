package com.adib.accounts.repository;

import com.adib.accounts.common.AccountTypeEnum;
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

        AccountDetails acc1 = new AccountDetails("123", AccountTypeEnum.SAVING, 10000.0);
        AccountDetails acc2 = new AccountDetails("456", AccountTypeEnum.CURRENT, 20000.0);
        AccountDetails acc3 = new AccountDetails("789", AccountTypeEnum.TD, 30000.0);
        AccountDetails acc4 = new AccountDetails("204", AccountTypeEnum.GHINA, 40000.0);

        accountList.add(acc1);
        accountList.add(acc2);
        accountList.add(acc3);
        accountList.add(acc4);
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

    public AccountDetails updateAccountType(String accountNumber, AccountTypeEnum accountType, Double accountBalance) {

        // for (AccountDetails acc : accountList) {
        //   if (acc.getAccountNumber().equals(accountNumber)) {
        //     acc.setAccountType(accountType);
        //   return acc;
        //}
        //}

        return null;
    }

    public void deleteAccount(String accountNumber) {
        for (AccountDetails acc : accountList) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                accountList.remove(acc);
                return;
            }
        }
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Invalid account number"
        );}
}