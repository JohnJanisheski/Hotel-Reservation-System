package com.HR.HRApp.bootstrap;

import com.HR.HRApp.domain.Account;
import com.HR.HRApp.domain.Reservation;
import com.HR.HRApp.domain.Room;
import com.HR.HRApp.domain.RoomType;
import com.HR.HRApp.repositories.accountRepository;
import com.HR.HRApp.repositories.reservationRepository;
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

    private final accountRepository accountRepository;
    private final roomRepository roomRepository;
    private final roomTypeRepository roomTypeRepository;
    private final reservationRepository reservationRepository;

    public bootStrapData(accountRepository accountRepository
    , roomTypeRepository roomTypeRepository
    , roomRepository roomRepository
    , reservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
        this.accountRepository = accountRepository;
        this.roomRepository = roomRepository;
        this.roomTypeRepository = roomTypeRepository;
    }


    @Override
    public void run(String... args) {

        //Adding Room Types
        ArrayList<RoomType> rt = new ArrayList<RoomType>();
        rt.add(new RoomType("Single Smoking", "Image URL", 120.00, 1, true));
        rt.add(new RoomType("Single Non Smoking", "Image URL", 100.00, 1, false));
        rt.add(new RoomType("Double Smoking", "Image URL", 170.00, 2, true));
        rt.add(new RoomType("Double Non Smoking", "Image URL", 150, 2, false));
        roomTypeRepository.saveAll(rt);

        //Adding Rooms
        ArrayList<Room> r = new ArrayList<Room>();
        Room room1 = new Room();
        r.add(new Room("101", "Single Bed Room Non Smoking", "Image URL", rt.get(1), 1, 1,true, 1));
        r.add(new Room("102", "Single Bed Room Non Smoking", "Image URL", rt.get(1), 1, 1,true, 1));
        r.add(new Room("103", "Single Bed Room Non Smoking", "Image URL", rt.get(1), 1, 1,true, 1));
        r.add(new Room("104", "Single Bed Room Non Smoking", "Image URL", rt.get(1), 1, 1,true, 1));
        r.add(new Room("105", "Single Bed Room Smoking", "Image URL", rt.get(0), 1, 1,true, 1));
        r.add(new Room("106", "Single Bed Room Smoking", "Image URL", rt.get(0), 1, 1,true, 1));
        r.add(new Room("107", "Single Bed Room Smoking", "Image URL", rt.get(0), 1, 1,true, 1));
        r.add(new Room("108", "Single Bed Room Smoking", "Image URL", rt.get(0), 1, 1,true, 1));
        r.add(new Room("201", "Double Bed Room Non Smoking", "Image URL", rt.get(3), 1, 2,true, 2));
        r.add(new Room("202", "Double Bed Room Non Smoking", "Image URL", rt.get(3), 1, 2,true, 2));
        r.add(new Room("203", "Double Bed Room Smoking", "Image URL", rt.get(2), 1, 2,true, 2));
        r.add(new Room("204", "Double Bed Room  Smoking", "Image URL", rt.get(2), 1, 2,true, 2));
        for (Room room: r){
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
        acc.add(new Account(0, "0", "0", "theapxy@gmail.com", "0"));
        acc.add(new Account(1, "0", "0", "theapxy@gmail.com", "1"));
        acc.add(new Account(2, "0", "0", "theapxy@gmail.com", "2"));
        accountRepository.saveAll(acc);

        //Create a Reservation
        //Dates are Month-Day-Year
        Reservation res1 = new Reservation("12-24-2020", "12-26-2020", acc.get(6).getEmail());
        Reservation res = new Reservation("12-24-2020", "12-26-2020", acc.get(0).getEmail());
        res.addRoomToReservation(r.get(9));
        res.addRoomToReservation(r.get(11));
        reservationRepository.save(res);
        reservationRepository.save(res1);
        //System.out.println(res.getReservation_id() + " : " + res.getReserved_rooms() + " : " + res.getReservedEndDate() + " : " + res.getReservedStartDate());


        List<Account> Employee = accountRepository.findAccountByType(1);
        System.out.println("Number of Employees = " + Employee.size());
        System.out.println("Number of accounts = " + accountRepository.count());
        System.out.println("Number of rooms = " + roomRepository.count());
        System.out.println("Number of room types = " + roomTypeRepository.count());
        System.out.println("Number of room types = " + reservationRepository.count());

    }
}

