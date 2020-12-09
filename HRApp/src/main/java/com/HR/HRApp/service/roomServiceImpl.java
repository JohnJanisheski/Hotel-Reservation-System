package com.HR.HRApp.service;

import com.HR.HRApp.domain.Room;
import com.HR.HRApp.repositories.roomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class roomServiceImpl implements roomService {

    @Autowired
    private roomRepository roomRepository;

    @Override
    public void setRoomIsLiveByNum(int roomNum, long accountTypeID) {
        List<Room> rooms = roomRepository.findRoomByisLive_TypeId(1, accountTypeID);

        for(int i=0; i< roomNum; i++)
        {
            Room tempRoom = rooms.get(i);
            System.out.println("r "+tempRoom.getId());
            System.out.println("r "+rooms.get(i).getId());
            roomRepository.deleteById(tempRoom.getId());
            tempRoom.setIsLive(2);
            roomRepository.save(tempRoom);
        }

    }

    @Override
    public Set<Room> getAvailableRoomList() {
        return roomRepository.findRoomByisLive(1);
    }
}
