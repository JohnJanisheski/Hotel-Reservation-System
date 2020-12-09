package com.HR.HRApp.service;

import com.HR.HRApp.domain.Reservation;
import com.HR.HRApp.repositories.reservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reservationServiceImpl implements reservationService {

    @Autowired
    private reservationRepository reservationRepository;

    @Override
    public List<Reservation> getAllReservtions() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getAllReservationByEmail(String email) {
        return reservationRepository.findAllReservationByEmail(email);
    }

    @Override
    public void saveReservation(Reservation reservation) {
        this.reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservationById(long id) {
        this.reservationRepository.deleteById(id);
    }
}
