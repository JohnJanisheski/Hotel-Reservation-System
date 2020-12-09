package com.HR.HRApp.service;

import com.HR.HRApp.domain.Room;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface roomService {
    //Reservation setRoomIsLiveByNum(int roomNum, long accountTypeID, Reservation reservation);

    Set<Room> getAvailableRoomList();

    Room getRoomById(long id);

    void save(Room room);

    void setReservationforRoom(long id);
}
