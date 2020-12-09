package com.HR.HRApp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_id")
    private Long reservation_id;

    private String reservedStartDate;
    private String reservedEndDate;

    @OneToMany
    @JoinColumn(name = "room_id")
    private Set<room> reserved_rooms = new HashSet<>();

    @ManyToOne
    private reservation reservation;//reservation Info

    public reservation() {
    }

    public reservation(String reservedStartDate, String reservedEndDate, Set<room> reserved_rooms) {
        this.reservedStartDate = reservedStartDate;
        this.reservedEndDate = reservedEndDate;
        this.reserved_rooms = reserved_rooms;
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

    public void setReserved_rooms(room room) {
        this.reserved_rooms.add(room);
    }
}
