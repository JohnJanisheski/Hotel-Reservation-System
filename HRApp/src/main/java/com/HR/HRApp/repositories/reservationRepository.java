package com.HR.HRApp.repositories;

import com.HR.HRApp.domain.reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface reservationRepository extends CrudRepository<reservation, Long> {
}
