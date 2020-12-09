package com.HR.HRApp.repositories;

import com.HR.HRApp.domain.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface accountRepository extends CrudRepository<Account, Long> {
    @Query("FROM Account where Email = ?1")
    List<Account> findByEmail(String email);

    @Query("FROM Account where Email = ?1 and password =?2")
    List<Account> findAccountByEmailAndPassword(String email, String password);

    @Query("FROM Account where type =?1 ")
    List<Account> findAccountByType(int type);

    @Query("From Account where isLoggedin = true")
    Account findLoggedInAccount();
}