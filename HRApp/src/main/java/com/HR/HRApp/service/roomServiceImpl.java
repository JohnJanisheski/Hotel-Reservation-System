package com.HR.HRApp.service;

import com.HR.HRApp.domain.Room;
import com.HR.HRApp.repositories.roomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class roomServiceImpl implements roomService {

    @Autowired
    private roomRepository roomRepository;

    @Autowired
    private accountService accountService;

    //@Override
    //public Reservation setRoomIsLiveByNum(int roomNum, long accountTypeID, Reservation reservation) {
    //    List<Room> rooms = roomRepository.findRoomByisLive_TypeId(1, accountTypeID);
//
//
//
    //    for(int i=0; i< roomNum; i++)
    //    {
    //        Room tempRoom = rooms.get(i);
    //        //System.out.println("r "+tempRoom.getId());
    //        //System.out.println("r "+rooms.get(i).getId());
    //        roomRepository.setIsLiveById(rooms.get(i).getId());
    //        //roomRepository.deleteById(tempRoom.getId());
    //        tempRoom.setIsLive(2);
    //        //roomRepository.save(tempRoom);
    //        reservation.addRoomToReservation(tempRoom);
    //    }
//
    //    accountSe®rvice.setReservationToAccount(reservation);
    //    return reservation;
    //}

    @Override
    public Set<Room> getAvailableRoomList() {
        return roomRepository.findRoomByisLive(1);
    }

    @Override
    public Room getRoomById(long id) {
        return roomRepository.myfindById(id);
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void setReservationforRoom(long id) {
        Room room = new Room();
        room = roomRepository.myfindById(id); //find the room type
        roomRepository.deleteById(id);
        room.setIsLive(2);
        roomRepository.save(room);
        accountService.getLoggedInAccount().addReservation(room);
    }
}
