package com.ikonnikova.banksystem.service;

import com.ikonnikova.banksystem.entity.Account;
import com.ikonnikova.banksystem.entity.Bill;
import com.ikonnikova.banksystem.exception.AccountNotFoundException;
import com.ikonnikova.banksystem.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long save(String name, String email, List<Bill> bills) {
        Account account = new Account(name, email, bills);
        return accountRepository.save(account).getAccountId();
    }

    public Account getById(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not find with id " + accountId));

    }

    public Account update(Account account) {
        return accountRepository.save(account);
    }
}
