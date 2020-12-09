package com.HR.HRApp.service;

import com.HR.HRApp.domain.Account;
import com.HR.HRApp.domain.Reservation;
import com.HR.HRApp.domain.Room;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
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

    Account getLoggedInAccount();

    void changeLoggedIn(Account account);

    void setAccountLogOut(Account logInaccount);

    void setReservationToAccount(Room room);
}
