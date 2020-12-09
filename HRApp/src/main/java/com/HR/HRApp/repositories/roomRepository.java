package com.HR.HRApp.repositories;

import com.HR.HRApp.domain.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roomRepository extends CrudRepository<Room, Long> {
}
