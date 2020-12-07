package com.HR.HRApp.repositories;

import com.HR.HRApp.domain.roomType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roomTypeRepository extends CrudRepository<roomType, Long> {
}
