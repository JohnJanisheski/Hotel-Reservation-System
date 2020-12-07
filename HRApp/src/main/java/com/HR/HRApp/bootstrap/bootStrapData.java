package com.HR.HRApp.bootstrap;

import com.HR.HRApp.domain.account;
//import com.HR.HRApp.domain.manager;
//import com.HR.HRApp.domain.customer;
//import com.HR.HRApp.repositories.customerRepository;
//import com.HR.HRApp.repositories.managerRepository;
import com.HR.HRApp.domain.room;
import com.HR.HRApp.domain.roomType;
import com.HR.HRApp.repositories.accountRepository;
import com.HR.HRApp.repositories.roomRepository;
import com.HR.HRApp.repositories.roomTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@EnableJpaRepositories("com.HR.HRApp.repositories")
@Component
public class bootStrapData implements CommandLineRunner {

    private final accountRepository accountRepository;
    private final roomRepository roomRepository;
    private final roomTypeRepository roomTypeRepository;

    public bootStrapData(
    accountRepository accountRepository
    ,roomTypeRepository roomTypeRepository
    ,roomRepository roomRepository) {
        this.accountRepository = accountRepository;
        this.roomRepository = roomRepository;
        this.roomTypeRepository = roomTypeRepository;
    }


    @Override
    public void run(String... args) {


        //room and roomtype
        room r1 =  new room();
        roomType rt1 = new roomType();
        r1.setRoomType(rt1);
        rt1.getRooms().add(r1);

        //Admin Accounts and Non Admin Accounts
        account acc = new account(2, "John", "Janisheski", "johnjanisheski99@gmail.com", "AdminPassword");
        accountRepository.save(acc);
        acc = new account(2, "Xinyi", "Peng", "theapxy@gmail.com", "AdminPassword");
        accountRepository.save(acc);
        acc = new account(2, "Sarah", "Derr", "test@gmail.com", "AdminPassword");
        accountRepository.save(acc);
        acc = new account(2, "Yuhui", "Last Name", "kkfiner@gmail.com", "AdminPassword");
        accountRepository.save(acc);
        acc = new account(0, "John", "Doe", "JohnDoe@gmail.com", "CustomerPassword");
        accountRepository.save(acc);
        acc = new account(1, "John", "Doe", "JohnDoe@gmail.com", "StaffPassword");
        accountRepository.save(acc);


        System.out.println("Opened in BootStrap");
        System.out.println("Number of accounts = " + accountRepository.count());
        System.out.println("Number of rooms = " + roomRepository.count());
        System.out.println("Number of room types = " + roomTypeRepository.count());
    }
}

