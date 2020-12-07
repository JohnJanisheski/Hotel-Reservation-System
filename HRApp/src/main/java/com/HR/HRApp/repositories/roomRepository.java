package com.HR.HRApp.repositories;

import com.HR.HRApp.domain.room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roomRepository extends CrudRepository<room, Long> {
}
