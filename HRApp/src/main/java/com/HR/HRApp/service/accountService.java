package com.HR.HRApp.service;

import com.HR.HRApp.domain.Account;


import java.util.List;

public interface accountService{
    //account save(accountRegisterDto registerDto);
    List<Account> getAllAccountByType(Account account);
    void saveAccount(Account account);
    Account getAccountById(long id);
    void deleteAccountById(long id);
    List<Account> getAccountByEmailAndPassword(String email, String password);
}
