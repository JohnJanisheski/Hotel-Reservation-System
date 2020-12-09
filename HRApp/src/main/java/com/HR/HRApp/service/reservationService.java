package com.HR.HRApp.service;

import com.HR.HRApp.domain.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface reservationService {

    List<Reservation> getAllReservtions();
    List<Reservation> getAllReservationByEmail(String email);

    void saveReservation(Reservation reservation);
    void deleteReservationById(long id);

    //void save(Reservation reservation);
}
