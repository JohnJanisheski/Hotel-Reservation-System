package com.HR.HRApp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long reservation_id;

    private String reservedStartDate;
    private String reservedEndDate;

    @OneToMany
    @JoinColumn(name = "room_id")
    private Set<Room> reserved_rooms = new HashSet<>();

    @JoinColumn(name = "email")
    private String reservation_email;

    @ManyToOne
    private Reservation reservation;//reservation Info

    private int roomNum; //number of rooms wanted

    private String double_single;
    private String isSmoking;

    public String getDouble_single() {
        return double_single;
    }

    public void setDouble_single(String double_single) {
        this.double_single = double_single;
    }

    public String getIsSmoking() {
        return isSmoking;
    }

    public void setIsSmoking(String isSmoking) {
        this.isSmoking = isSmoking;
    }

    public Reservation(){}

    public Reservation(String reservedStartDate, String reservedEndDate, String email) {
        this.reservedStartDate = reservedStartDate;
        this.reservedEndDate = reservedEndDate;
        this.reservation_email = email;
    }

    public Reservation(String reservedStartDate, String reservedEndDate, String email, int roomNum) {
        this.reservedStartDate = reservedStartDate;
        this.reservedEndDate = reservedEndDate;
        this.reservation_email = email;
        this.roomNum = roomNum;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public void addRoomToReservation(Room room){
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

    public Set<Room> getReserved_rooms() {
        return reserved_rooms;
    }

    public void setReserved_rooms(Set<Room> reserved_rooms) {
        this.reserved_rooms = reserved_rooms;
    }

    public String getReservationEmail() {
        return reservation_email;
    }

    public void setReservation_email(String email) {
        this.reservation_email = email;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getRoomNames()
    {
        String res = "";
        for ( Room room : getReserved_rooms()
             ) {
            res+=room.getRoomName()+"\n";
        }
        return res;
    }
}
