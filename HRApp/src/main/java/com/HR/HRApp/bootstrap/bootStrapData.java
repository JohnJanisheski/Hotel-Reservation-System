package com.HR.HRApp.bootstrap;

import com.HR.HRApp.domain.Account;
import com.HR.HRApp.domain.room;
import com.HR.HRApp.domain.roomType;
import com.HR.HRApp.repositories.accountRepository;
import com.HR.HRApp.repositories.roomRepository;
import com.HR.HRApp.repositories.roomTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@EnableJpaRepositories("com.HR.HRApp.repositories")
@Component
public class bootStrapData implements CommandLineRunner {

    public boolean loggedIn = false;
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
        //Adding Room Types
        ArrayList<roomType> rt = new ArrayList<roomType>();
        rt.add(new roomType("Single Smoking", "Image URL", 120.00, 1, true));
        rt.add(new roomType("Single Non Smoking", "Image URL", 100.00, 1, false));
        rt.add(new roomType("Double Smoking", "Image URL", 170.00, 2, true));
        rt.add(new roomType("Double Non Smoking", "Image URL", 150, 2, false));
        roomTypeRepository.saveAll(rt);

        //Adding Rooms
        ArrayList<room> r = new ArrayList<room>();
        r.add(new room("101", "Single Bed Room Non Smoking", "Image URL", rt.get(1), 1, 1,true ));
        r.add(new room("102", "Single Bed Room Non Smoking", "Image URL", rt.get(1), 1, 1,true ));
        r.add(new room("103", "Single Bed Room Non Smoking", "Image URL", rt.get(1), 1, 1,true ));
        r.add(new room("104", "Single Bed Room Non Smoking", "Image URL", rt.get(1), 1, 1,true ));
        r.add(new room("105", "Single Bed Room Smoking", "Image URL", rt.get(0), 1, 1,true ));
        r.add(new room("106", "Single Bed Room Smoking", "Image URL", rt.get(0), 1, 1,true ));
        r.add(new room("107", "Single Bed Room Smoking", "Image URL", rt.get(0), 1, 1,true ));
        r.add(new room("108", "Single Bed Room Smoking", "Image URL", rt.get(0), 1, 1,true ));
        r.add(new room("201", "Double Bed Room Non Smoking", "Image URL", rt.get(3), 1, 2,true ));
        r.add(new room("202", "Double Bed Room Non Smoking", "Image URL", rt.get(3), 1, 2,true ));
        r.add(new room("203", "Double Bed Room Smoking", "Image URL", rt.get(2), 1, 2,true ));
        r.add(new room("204", "Double Bed Room  Smoking", "Image URL", rt.get(2), 1, 2,true ));
        for (room room: r){
            roomRepository.save(room);
            //Add the room to the roomType
            if (room.getRemark().contains("Single")){
                if(room.getRemark().contains("Non"))
                    rt.get(1).addRoom(room);
                else
                    rt.get(0).addRoom(room);
            }
            else{
                if(room.getRemark().contains("Non"))
                    rt.get(3).addRoom(room);
                else
                    rt.get(2).addRoom(room);
            }
        }
        roomTypeRepository.saveAll(rt);

        //Admin Accounts and Non Admin Accounts
        ArrayList<Account> acc = new ArrayList<Account>();
        acc.add(new Account(2, "John", "Janisheski", "johnjanisheski99@gmail.com", "AdminPassword"));
        acc.add(new Account(2, "Xinyi", "Peng", "theapxy@gmail.com", "AdminPassword"));
        acc.add(new Account(2, "Sarah", "Derr", "test@gmail.com", "AdminPassword"));
        acc.add(new Account(2, "Yuhui", "Last Name", "kkfiner@gmail.com", "AdminPassword"));
        acc.add(new Account(0, "John", "Doe", "JohnDoe@gmail.com", "CustomerPassword"));
        acc.add(new Account(1, "John", "Doe", "JohnDoe@gmail.com", "StaffPassword"));
        accountRepository.saveAll(acc);

//        accountRepository.findAll().forEach(account -> {
//            System.out.println(account.getEmail());
//        });

        List<Account> EP = this.accountRepository.findAccountByEmailAndPassword("johnjanisheski99@gmail.com", "AdminPassword");
        List<Account> E = this.accountRepository.findByEmail("theapxy@gmail.com");
        System.out.println(((Account)E.get(0)).getPassword());
        System.out.println("Opened in BootStrap");
        System.out.println("size of searchAccount:" + EP.size());
        System.out.println("size of searchAccount by email:" + E.size());
        System.out.println("Number of accounts = " + this.accountRepository.count());
        System.out.println("Number of rooms = " + this.roomRepository.count());
        System.out.println("Number of room types = " + this.roomTypeRepository.count());
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}

