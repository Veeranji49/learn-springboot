package com.example.Service;

import com.example.Entity.Account;
import com.example.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void saveAccounts(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void deleteAccountById(long id) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account != null) {
            accountRepository.deleteById(id);
        } else {
            throw new RuntimeException("Account ID is invalid");
        }
    }

    @Override
    public Account getAccountById(long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account ID is invalid"));
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public double getBalanceById(long id) {
        return accountRepository.getBalanceById(id);
    }

    @Override
    public void depositToAccountById(long id, Double amount) {
        accountRepository.depositToAccountById(id, amount);
    }

    @Override
    public void withdrawFromAccountById(long id, Double amount) {
        accountRepository.withdrawFromAccountById(id, amount);
    }
}
