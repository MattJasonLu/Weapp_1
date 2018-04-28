package com.ljc.pojo;

import java.util.Date;

/**
 * Created by matt on 2018/4/27.
 */
public class Turnover {
    private int id;
    private int cardId;
    private float consumption;
    private Date time;
    private String name;
    private String place;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public float getConsumption() {
        return consumption;
    }

    public void setConsumption(float consumption) {
        this.consumption = consumption;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Turnover{" +
                "id=" + id +
                ", cardId=" + cardId +
                ", consumption=" + consumption +
                ", time=" + time +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
