package com.example.Controller;

import com.example.Entity.Account;
import com.example.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/account/id/{id}")
    public Account addAccount(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @DeleteMapping("/account/id/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccountById(id);
    }

    @GetMapping("/account/id/{id}/balance")
    public Double getAccountBalance(@PathVariable Long id) {
        return accountService.getBalanceById(id);
    }

    @PutMapping("/account/id/{id}/deposit/{amount}")
    public void depositToAccount(@PathVariable Long id, @PathVariable Double amount) {
        accountService.depositToAccountById(id, amount);
    }

    @PutMapping("/account/id/{id}/withdraw/{amount}")
    public void withdrawFromAccount(@PathVariable Long id, @PathVariable Double amount) {
        accountService.withdrawFromAccountById(id, amount);
    }

}