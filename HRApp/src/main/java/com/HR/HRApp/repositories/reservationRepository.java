package com.HR.HRApp.repositories;

import com.HR.HRApp.domain.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface reservationRepository extends CrudRepository<Reservation, Long> {

    @Query("from Reservation where reservation_email=?1")
    List<Reservation> findAllReservationByEmail(String email);
}
