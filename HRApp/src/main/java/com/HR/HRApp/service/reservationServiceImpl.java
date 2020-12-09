package com.HR.HRApp.service;

import com.HR.HRApp.domain.Reservation;
import com.HR.HRApp.repositories.reservationRepository;
import com.HR.HRApp.repositories.roomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reservationServiceImpl implements reservationService {

    @Autowired
    private reservationRepository reservationRepository;

    @Autowired
    private roomService roomService;

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

    //@Override
    //public void save(Reservation reservation) {
    //    //
    //    //System.out.println(reservation.getIsSmoking());
    //    //System.out.println(reservation.getDouble_single());
    //    long accountTypeID = 0;
    //    if(reservation.getIsSmoking() == "yes")//non-smoking
    //    {
    //        if(reservation.getDouble_single() == "double")
    //        {
    //            accountTypeID = 4; //non double
    //        }
    //        else
    //            accountTypeID = 2; //non sig
    //    }
    //    else { //smoking
    //        if(reservation.getDouble_single() == "double")
    //        {
    //            accountTypeID =3; //s, d
    //        }
    //        else
    //            accountTypeID =1;  // s, s
    //    }
//
    //    reservationRepository.save(reservation);
//
    //    roomService.setRoomIsLiveByNum(reservation.getRoomNum(),accountTypeID, reservation);
//
    //    System.out.println(reservation.getRoomNames()+reservation.getReservation_id());
    //}
}
