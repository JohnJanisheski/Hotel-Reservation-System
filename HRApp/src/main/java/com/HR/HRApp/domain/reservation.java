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

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "room_id")
    private Set<room> reserved_rooms = new HashSet<>();
}
