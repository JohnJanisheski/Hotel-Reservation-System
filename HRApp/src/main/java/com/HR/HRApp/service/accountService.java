package com.HR.HRApp.service;

import com.HR.HRApp.domain.Account;


import java.util.List;

public interface accountService{
    //account save(accountRegisterDto registerDto);
    List<Account> getAllAccountByType(int type);

    //save account for customer
    void saveAccount(Account account);

    //save account for employee
    void saveEmployee(Account employee);

    //save account for manager
    void saveManager(Account manager);

    Account getAccountById(long id);
    void deleteAccountById(long id);
    List<Account> getAccountByEmailAndPassword(String email, String password);

}
