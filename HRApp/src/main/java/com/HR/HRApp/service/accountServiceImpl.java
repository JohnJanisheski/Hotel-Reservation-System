package com.HR.HRApp.service;

import com.HR.HRApp.domain.Account;
import com.HR.HRApp.repositories.accountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class accountServiceImpl implements accountService{

    @Autowired
    private accountRepository accountRepository;


    @Override
    public List<Account> getAllAccountByType(Account account) {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        this.accountRepository.save(account);
    }

    @Override
    public Account getAccountById(long id) {
        Optional<Account> optional = accountRepository.findById(id);
        Account account = null;
        if (optional.isPresent()) {
            account = optional.get();
        } else {
            throw new RuntimeException(" Account not found for id :: " + id);
        }
        return account;
    }

    @Override
    public void deleteAccountById(long id) {
        this.accountRepository.deleteById(id);
    }
}
