package com.HR.HRApp.service;

import com.HR.HRApp.domain.Room;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface roomService {
    void setRoomIsLiveByNum(int roomNum, long accountTypeID);

    Set<Room> getAvailableRoomList();
}
