package com.HR.HRApp.repositories;

import com.HR.HRApp.domain.Reservation;
import com.HR.HRApp.domain.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface roomRepository extends CrudRepository<Room, Long> {

    @Query("from Room where isLive=?1")
    Set<Room> findRoomByisLive(int isLive);

    @Query("from Room where isLive = ?1 and roomType.id = ?2")
    List<Room> findRoomByisLive_TypeId(int i, long accountTypeID);

    @Query("update Room set isLive=1 where id = ?1")
    void setIsLiveById(long id);

    @Query("from Room where id=?1")
    Room myfindById(long id);
}
