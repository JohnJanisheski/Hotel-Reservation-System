package com.HR.HRApp.bootstrap;

import com.HR.HRApp.domain.account;
import com.HR.HRApp.domain.staff;
import com.HR.HRApp.repositories.accountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootStrapData implements CommandLineRunner {

    private final accountRepository accountRepository;

    public bootStrapData(com.HR.HRApp.repositories.accountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public void run(String... args) {
        account tmp1 = new account(2, "John", "Doe", "Admin", "password123");
        accountRepository.save(tmp1);

        staff tmp = new staff();
        account tmp2 = new account(tmp);
        accountRepository.save(tmp2);


        System.out.println("Opened in BootStrap");
        System.out.println("Number of accounts = " + accountRepository.count());
    }
}

