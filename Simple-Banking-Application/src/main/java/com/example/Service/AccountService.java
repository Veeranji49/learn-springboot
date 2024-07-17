package com.example.Service;

import com.example.Entity.Account;

import java.util.List;

public interface AccountService {

    public void saveAccounts(Account account);

    public void deleteAccountById(long id);

    public Account getAccountById(long id);

    public List<Account> getAllAccounts();

    public double getBalanceById(long id);

    public void depositToAccountById(long id, Double amount);

    public void withdrawFromAccountById(long id, Double amount);
}
