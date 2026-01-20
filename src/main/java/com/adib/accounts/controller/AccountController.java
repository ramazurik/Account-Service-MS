package com.adib.accounts.controller;


import com.adib.accounts.models.response.AccountDetails;
import com.adib.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping//("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountNumber}")
    public AccountDetails getAccountByAccountNumber(@PathVariable("accountNumber") String accountNumber) {

        return accountService.getAccountByAccountNumber(accountNumber);

    }

    @PostMapping("/")
    public String createAccount(@RequestBody AccountDetails accountDetails) {
        accountService.createAccount(accountDetails);
        return "Account created successfully";
    }

    @DeleteMapping("/{accountNumber}")
    public String deleteAccount(@PathVariable String accountNumber) {
        boolean deleted = accountService.deleteAccount(accountNumber);

        if (deleted) {
            return "Account deleted successfully";
        } else {
            return "Account not found";
        }
    }
}