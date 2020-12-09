package com.HR.HRApp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import com.HR.HRApp.domain.Account;
import com.HR.HRApp.domain.reservation;
import com.HR.HRApp.domain.room;
import com.HR.HRApp.domain.roomType;
import com.HR.HRApp.repositories.accountRepository;
import com.HR.HRApp.repositories.reservationRepository;
import com.HR.HRApp.repositories.roomRepository;
import com.HR.HRApp.repositories.roomTypeRepository;

@Entity
public class reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long reservation_id;

    private String reservedStartDate;
    private String reservedEndDate;

    @OneToMany
    @JoinColumn(name = "room_id")
    private Set<room> reserved_rooms = new HashSet<>();

    @JoinColumn(name = "email")
    private String reservation_email;

    @ManyToOne
    private reservation reservation;//reservation Info

    public reservation() {
    }

    public reservation(String reservedStartDate, String reservedEndDate, String email) {
        this.reservedStartDate = reservedStartDate;
        this.reservedEndDate = reservedEndDate;
        this.reservation_email = email;
    }

    public void addRoomToReservation(room room){
        this.reserved_rooms.add(room);
    }

    public Long getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Long reservation_id) {
        this.reservation_id = reservation_id;
    }

    public String getReservedStartDate() {
        return reservedStartDate;
    }

    public void setReservedStartDate(String reservedStartDate) {
        this.reservedStartDate = reservedStartDate;
    }

    public String getReservedEndDate() {
        return reservedEndDate;
    }

    public void setReservedEndDate(String reservedEndDate) {
        this.reservedEndDate = reservedEndDate;
    }

    public Set<room> getReserved_rooms() {
        return reserved_rooms;
    }

    public void setReserved_rooms(Set<room> reserved_rooms) {
        this.reserved_rooms = reserved_rooms;
    }

    public String getReservationEmail() {
        return reservation_email;
    }

    public void setReservation_email(String email) {
        this.reservation_email = email;
    }

    public com.HR.HRApp.domain.reservation getReservation() {
        return reservation;
    }

    public void setReservation(com.HR.HRApp.domain.reservation reservation) {
        this.reservation = reservation;
    }
}
