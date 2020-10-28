package com.HR.HRApp.bootstrap;

import com.HR.HRApp.domain.account;
import com.HR.HRApp.domain.room;
import com.HR.HRApp.domain.roomType;
import com.HR.HRApp.domain.staff;
import com.HR.HRApp.repositories.accountRepository;
import com.HR.HRApp.repositories.roomRepository;
import com.HR.HRApp.repositories.roomTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootStrapData implements CommandLineRunner {

    private final accountRepository accountRepository;
    private final roomRepository roomRepository;
    private final roomTypeRepository roomTypeRepository;

    public bootStrapData(com.HR.HRApp.repositories.accountRepository accountRepository
    ,roomTypeRepository roomTypeRepository
    ,roomRepository roomRepository) {
        this.accountRepository = accountRepository;
        this.roomRepository = roomRepository;
        this.roomTypeRepository = roomTypeRepository;
    }


    @Override
    public void run(String... args) {

        //account
        account tmp1 = new account(2, "John", "Doe", "Admin", "Admin".toCharArray().toString());
        accountRepository.save(tmp1);

        staff tmp = new staff();
        account tmp2 = new account(tmp);
        accountRepository.save(tmp2);

        //room and roomtype
        room r1 =  new room();
        roomType rt1 = new roomType();

        r1.setRoomType(rt1);
        rt1.getRooms().add(r1);


        roomTypeRepository.save(rt1);
        roomRepository.save(r1);

        System.out.println("Opened in BootStrap");
        System.out.println("Number of accounts = " + accountRepository.count());
        System.out.println("Number of accounts = " + roomRepository.count());
        System.out.println("Number of accounts = " + roomTypeRepository.count());
    }
}

