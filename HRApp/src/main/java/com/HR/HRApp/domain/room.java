package com.HR.HRApp.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String roomName;//room number
    private String remark;//room description
    private String image;//room image

    @Column(name = "roomType")
    private int type;//1 is Single, 2 is double

    private int isLive;//1: empty room, 2: reserved, 3: moved in/occupied, 4: room is out of order, 5: checked out
    private int floor; //floor: 1, 2
    private boolean isClean; //isCleaned?

    @ManyToOne
    private roomType roomType;//room category

    @ManyToOne
    private reservation reservation;//reservation Info


    public room() {
    }

    public room(String roomName, String remark, String image, com.HR.HRApp.domain.roomType roomType, int isLive, int floor, boolean isClean, int type) {
        this.roomName = roomName;
        this.remark = remark;
        this.image = image;
        this.roomType = roomType;
        this.isLive = isLive;
        this.floor = floor;
        this.isClean = isClean;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    public com.HR.HRApp.domain.reservation getReservation() {
        return reservation;
    }

    public void setReservation(com.HR.HRApp.domain.reservation reservation) {
        this.reservation = reservation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public com.HR.HRApp.domain.roomType getRoomType() {
        return roomType;
    }

    public void setRoomType(com.HR.HRApp.domain.roomType roomType) {
        this.roomType = roomType;
    }

    public int getIsLive() {
        return isLive;
    }

    public void setIsLive(int isLive) {
        this.isLive = isLive;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean getIsClean() {
        return isClean;
    }

    public void setIsClean(boolean isClean) {
        this.isClean = isClean;
    }


}
