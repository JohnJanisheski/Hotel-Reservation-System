package com.HR.HRApp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class roomType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    private long id;

    private String roomTypeName;// room type name
    private String image;//image on the homepage/introduction page
    private double price;//price

    @Column(name = "roomType")
    private int type;//1: single room, 2: double room

    private int num;//the number of available rooms of this type
    private boolean isAllowSmoking; //false: not allow. true: allow


    @OneToMany
    @JoinColumn(name = "room_id")
    private Set<room> rooms = new HashSet<>();

    public roomType() {
    }

    public roomType(String roomTypeName
            , String image
            , double price
            , int type
            , boolean isAllowSmoking)
    {
        this.num = 0;
        this.roomTypeName = roomTypeName;
        this.image = image;
        this.price = price;
        this.type = type;
        this.isAllowSmoking = isAllowSmoking;
    }

    public Set<room> getRooms() {
        return this.rooms;
    }

    public void addRoom(room rooms) {
        this.rooms.add(rooms);
        this.num = this.num + 1;
    }

    public void increaseNum(){this.num++;}

    public void decreaseNum() {this.num--;}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isAllowSmoking() {
        return isAllowSmoking;
    }

    public void setAllowSmoking(boolean allowSmoking) {
        isAllowSmoking = allowSmoking;
    }

}
