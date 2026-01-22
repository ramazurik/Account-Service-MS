package com.adib.accounts.controller;


import com.adib.accounts.models.request.UpdateAccountRequest;
import com.adib.accounts.models.response.AccountDetails;
import com.adib.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDetails createAccount(@RequestBody AccountDetails accountDetails) {
        accountService.createAccount(accountDetails);
        return  accountDetails;
    }
    //added
    @PutMapping("/{accountNumber}")
    public AccountDetails updateAccountType(@RequestBody UpdateAccountRequest updateAccountRequest, @PathVariable("accountNumber") String accountNumber) {

        return accountService.updateAccountType(updateAccountRequest, accountNumber);
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String accountNumber) {
        accountService.deleteAccount(accountNumber);
        return ResponseEntity.noContent().build();
    }
}