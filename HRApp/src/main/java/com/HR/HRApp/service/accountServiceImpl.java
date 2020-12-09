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
    public List<Account> getAllAccountByType(int type) {
        return accountRepository.findAccountByType(type);
    }

    @Override
    public void saveAccount(Account account) {
        this.accountRepository.save(account);
    }

    @Override
    public void saveEmployee(Account employee) {
        employee.setType(1);
        this.accountRepository.save(employee);
    }

    @Override
    public void saveManager(Account manager) {
        manager.setType(2);
        this.accountRepository.save(manager);
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

    @Override
    public List<Account> getAccountByEmailAndPassword(String email, String password) {
        return accountRepository.findAccountByEmailAndPassword(email, password);
        // var accounts = (List<Account>) accountRepository.findAll();
        // List<Account> res = null;

        // for (Account account : accounts) {
        //     if(account.getEmail() == email && account.getPassword() == password)
        //         res.add(account);
        // }
        // return res;
    }
}
